package ua.edu.ukma.stasiuk.nativeplayground.delegate;


import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;
import ua.edu.ukma.stasiuk.nativeplayground.domain.SubscriptionEntity;
import ua.edu.ukma.stasiuk.nativeplayground.domain.SubscriptionEntityConstraints;
import ua.edu.ukma.stasiuk.nativeplayground.domain.mapper.SubscriptionMapper;
import ua.edu.ukma.stasiuk.nativeplayground.dto.NewSubscriptionDto;
import ua.edu.ukma.stasiuk.nativeplayground.dto.SubscriptionDto;
import ua.edu.ukma.stasiuk.nativeplayground.exception.SubscriptionServiceNameIsNotUniqueException;
import ua.edu.ukma.stasiuk.nativeplayground.repository.SubscriptionRepository;

@Component
public class SubscriptionApiDelegate {

    private final SubscriptionRepository subscriptionRepository;
    private final SubscriptionMapper subscriptionMapper;

    public SubscriptionApiDelegate(SubscriptionRepository subscriptionRepository,
                                   SubscriptionMapper subscriptionMapper) {
        this.subscriptionRepository = subscriptionRepository;
        this.subscriptionMapper = subscriptionMapper;
    }

    public Iterable<SubscriptionDto> getSubscriptions() {
        var entities = subscriptionRepository.findAll();
        return subscriptionMapper.convertSubscriptionEntityListToDtoList(entities);
    }

    public Iterable<SubscriptionDto> getSubscriptionsWithNotes() {
        var entities = subscriptionRepository.findAllByNotesNotNull();
        return subscriptionMapper.convertSubscriptionEntityListToDtoList(entities);
    }

    public SubscriptionDto createSubscription(NewSubscriptionDto newSubscriptionDto) {
        var entity = subscriptionMapper.convertNewSubscriptionDtoToEntity(newSubscriptionDto);

        try {
            entity = subscriptionRepository.saveAndFlush(entity);
        } catch (DataIntegrityViolationException ex) {
            handleDataIntegrityViolationException(ex, entity);
        }

        return subscriptionMapper.convertSubscriptionEntityToDto(entity);
    }

    private void handleDataIntegrityViolationException(DataIntegrityViolationException ex, SubscriptionEntity subscriptionEntity) {
        if (ex.getCause() != null &&
                ex.getCause() instanceof ConstraintViolationException cause &&
                SubscriptionEntityConstraints.SERVICE_NAME_UNIQUE.equals(cause.getConstraintName())) {
            throw new SubscriptionServiceNameIsNotUniqueException(subscriptionEntity.getServiceName(), ex);
        }

        throw ex;
    }
}