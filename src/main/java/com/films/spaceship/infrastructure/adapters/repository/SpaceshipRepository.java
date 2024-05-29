package com.films.spaceship.infrastructure.adapters.repository;

import com.films.spaceship.infrastructure.adapters.entity.SpaceshipEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpaceshipRepository extends JpaRepository<SpaceshipEntity, Long> {
}
