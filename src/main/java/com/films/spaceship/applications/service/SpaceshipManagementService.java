package com.films.spaceship.applications.service;

import com.films.spaceship.applications.mapper.SpaceshipDtoMapper;
import com.films.spaceship.applications.mapper.SpaceshipRequestMapper;
import com.films.spaceship.applications.usecases.SpaceshipService;
import com.films.spaceship.domain.dto.SpaceshipDto;
import com.films.spaceship.domain.dto.request.SpaceshipRequest;
import com.films.spaceship.domain.port.SpaceshipPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SpaceshipManagementService implements SpaceshipService {

    private final SpaceshipPersistencePort spaceshipPersistencePort;
    private final SpaceshipRequestMapper spaceshipRequestMapper;
    private final SpaceshipDtoMapper spaceshipDtoMapper;

    @Override
    public SpaceshipDto createNew(SpaceshipRequest request) {
        var spaceshipRequest = spaceshipRequestMapper.toDomain(request);
        var spaceshipCreated = spaceshipPersistencePort.create(spaceshipRequest);
        return spaceshipDtoMapper.toDto(spaceshipCreated);
    }

    @Override
    public SpaceshipDto getById(Long id) {
        var spaceship = spaceshipPersistencePort.getById(id);
        return spaceshipDtoMapper.toDto(spaceship);
    }

    @Override
    public List<SpaceshipDto> getAll() {
        var spaceships = spaceshipPersistencePort.getAll();
        return spaceships
                .stream()
                .map(spaceshipDtoMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        spaceshipPersistencePort.deleteById(id);
    }

    @Override
    public SpaceshipDto update(SpaceshipRequest request, Long id) {
        var spaceshipToUpdate = spaceshipRequestMapper.toDomain(request);

        var spaceshipUpdated = spaceshipPersistencePort.update(spaceshipToUpdate);

        return spaceshipDtoMapper.toDto(spaceshipUpdated);
    }

}
