package com.films.spaceship.applications.mapper;

import com.films.spaceship.domain.dto.request.SpaceshipRequest;
import com.films.spaceship.domain.model.Spaceship;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring") 
public interface SpaceshipRequestMapper {


    @Mapping(source = "name", target = "name")
    @Mapping(source = "film", target = "film")
    Spaceship toDomain(SpaceshipRequest request);
}
