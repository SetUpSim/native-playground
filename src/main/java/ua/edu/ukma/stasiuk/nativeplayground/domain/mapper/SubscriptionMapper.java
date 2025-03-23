package ua.edu.ukma.stasiuk.nativeplayground.domain.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ua.edu.ukma.stasiuk.nativeplayground.domain.SubscriptionEntity;
import ua.edu.ukma.stasiuk.nativeplayground.dto.NewSubscriptionDto;
import ua.edu.ukma.stasiuk.nativeplayground.dto.SubscriptionDto;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class SubscriptionMapper {

    public abstract SubscriptionDto convertSubscriptionEntityToDto(SubscriptionEntity entity);

    public abstract List<SubscriptionDto> convertSubscriptionEntityListToDtoList(List<SubscriptionEntity> entityList);

    @Mapping(target = "active", constant = "true")
    public abstract SubscriptionEntity convertNewSubscriptionDtoToEntity(NewSubscriptionDto newSubscriptionDto);

}
