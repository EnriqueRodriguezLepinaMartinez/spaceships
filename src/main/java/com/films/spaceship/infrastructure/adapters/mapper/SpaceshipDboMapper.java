package com.films.spaceship.infrastructure.adapters.mapper;

import com.films.spaceship.domain.model.Spaceship;
import com.films.spaceship.infrastructure.adapters.entity.SpaceshipEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SpaceshipDboMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "film", target = "film")
    @Mapping(source = "dateOfCreation", target = "dateOfCreation")
    SpaceshipEntity toDbo(Spaceship domain);

    @InheritInverseConfiguration
    Spaceship toDomain(SpaceshipEntity entity);
}