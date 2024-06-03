package com.films.spaceship.applications.usecases;

import com.films.spaceship.domain.dto.SpaceshipDto;
import com.films.spaceship.domain.dto.request.SpaceshipRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SpaceshipService {
    SpaceshipDto createNew(SpaceshipRequest request);
    SpaceshipDto getByName(String name);
    SpaceshipDto getById(Long id);
    Page<SpaceshipDto> getAll(Pageable pageable);
    void deleteById(Long id);
    SpaceshipDto update(SpaceshipRequest request, Long id);

}
