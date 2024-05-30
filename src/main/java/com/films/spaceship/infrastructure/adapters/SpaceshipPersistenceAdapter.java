package com.films.spaceship.infrastructure.adapters;

import com.films.spaceship.domain.model.Spaceship;
import com.films.spaceship.domain.model.constants.SpaceshipConstant;
import com.films.spaceship.domain.port.SpaceshipPersistencePort;
import com.films.spaceship.infrastructure.adapters.exceptions.SpaceshipException;
import com.films.spaceship.infrastructure.adapters.mapper.SpaceshipDboMapper;
import com.films.spaceship.infrastructure.adapters.repository.SpaceshipRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public Spaceship getByName(String name) {
        var optionalSpaceship = spaceshipRepository.findByName(name.toUpperCase());

        if (optionalSpaceship.isEmpty()){
            throw new SpaceshipException(HttpStatus.NOT_FOUND,
                    String.format(SpaceshipConstant.NOT_FOUND_MESSAGE_ERROR, name));
        }

        return spaceshipDboMapper.toDomain(optionalSpaceship.get());
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
    public Page<Spaceship> getAll(Pageable pageable) {
        var allItems = spaceshipRepository.findAll(pageable)
                .stream()
                .map(spaceshipDboMapper::toDomain)
                .collect(Collectors.toList());

        return new PageImpl<>(allItems);
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
