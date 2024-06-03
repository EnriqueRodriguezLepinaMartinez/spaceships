package com.films.spaceship.domain.port;

import com.films.spaceship.domain.model.Spaceship;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SpaceshipPersistencePort {

    Spaceship create(Spaceship user);

    Spaceship getByName(String name);
    Spaceship getById(Long id);
    Page<Spaceship> getAll(Pageable pageable);
    void deleteById(Long id);
    Spaceship update(Spaceship user);

}
