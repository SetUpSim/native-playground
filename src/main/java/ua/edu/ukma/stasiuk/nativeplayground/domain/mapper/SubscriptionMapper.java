package ua.edu.ukma.stasiuk.nativeplayground.domain.mapper;

import org.mapstruct.Mapper;
import ua.edu.ukma.stasiuk.nativeplayground.domain.SubscriptionEntity;
import ua.edu.ukma.stasiuk.nativeplayground.dto.SubscriptionDto;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class SubscriptionMapper {

    public abstract SubscriptionDto convertSubscriptionEntityToDto(SubscriptionEntity entity);

    public abstract List<SubscriptionDto> convertSubscriptionEntityListToDtoList(List<SubscriptionEntity> entityList);

}
