package com.films.spaceship.applications.usecases;

import com.films.spaceship.domain.dto.SpaceshipDto;
import com.films.spaceship.domain.dto.request.SpaceshipRequest;

import java.util.List;

public interface SpaceshipService {
    SpaceshipDto createNew(SpaceshipRequest request);
    SpaceshipDto getById(Long id);
    List<SpaceshipDto> getAll();
    void deleteById(Long id);
    SpaceshipDto update(SpaceshipRequest request, Long id);

}
