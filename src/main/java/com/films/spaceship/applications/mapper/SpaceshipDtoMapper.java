package com.films.spaceship.applications.mapper;

import com.films.spaceship.domain.dto.SpaceshipDto;
import com.films.spaceship.domain.model.Spaceship;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring") 
public interface SpaceshipDtoMapper {


    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "film", target = "film")
    @Mapping(source = "dateOfCreation", target = "dateOfCreation")
    SpaceshipDto toDto(Spaceship domain);

}
