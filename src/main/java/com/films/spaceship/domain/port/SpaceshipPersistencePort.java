package com.films.spaceship.domain.port;

import com.films.spaceship.domain.model.Spaceship;

import java.util.List;

public interface SpaceshipPersistencePort {

    Spaceship create(Spaceship user);
    Spaceship getById(Long id);
    List<Spaceship> getAll();
    void deleteById(Long id);
    Spaceship update(Spaceship user);

}
