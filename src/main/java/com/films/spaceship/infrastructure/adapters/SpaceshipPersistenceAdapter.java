package com.films.spaceship.infrastructure.adapters;

import com.films.spaceship.domain.model.Spaceship;
import com.films.spaceship.domain.model.constants.SpaceshipConstant;
import com.films.spaceship.domain.port.SpaceshipPersistencePort;
import com.films.spaceship.infrastructure.adapters.exceptions.SpaceshipException;
import com.films.spaceship.infrastructure.adapters.mapper.SpaceshipDboMapper;
import com.films.spaceship.infrastructure.adapters.repository.SpaceshipRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class SpaceshipPersistenceAdapter implements SpaceshipPersistencePort {

    private final SpaceshipRepository spaceshipRepository;
    private final SpaceshipDboMapper spaceshipDboMapper;

    /**
     * Create the new spaceship
     * @param spaceship the object to save
     * @return the spaceship
     */
    @Override
    public Spaceship create(Spaceship spaceship) {

        var spaceshipToSave = spaceshipDboMapper.toDbo(spaceship);
        var spaceshipSaved = spaceshipRepository.save(spaceshipToSave);

        return spaceshipDboMapper.toDomain(spaceshipSaved);
    }

    @Override
    public Spaceship getById(Long id) {


        var optionalSpaceship = spaceshipRepository.findById(id);

        if (optionalSpaceship.isEmpty()){
            throw new SpaceshipException(HttpStatus.NOT_FOUND,
                    String.format(SpaceshipConstant.NOT_FOUND_MESSAGE_ERROR, id));
        }

        return spaceshipDboMapper.toDomain(optionalSpaceship.get());
    }

    @Override
    public List<Spaceship> getAll() {
        return spaceshipRepository.findAll()
                .stream()
                .map(spaceshipDboMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        spaceshipRepository.deleteById(id);
    }

    @Override
    public Spaceship update(Spaceship spaceship) {

        var spaceshipToUpdate = spaceshipDboMapper.toDbo(spaceship);
        var spaceshipUpdated = spaceshipRepository.save(spaceshipToUpdate);

        return spaceshipDboMapper.toDomain(spaceshipUpdated);
    }
}
