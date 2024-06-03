package com.films.spaceship.infrastructure.adapters.repository;

import com.films.spaceship.infrastructure.adapters.entity.SpaceshipEntity;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpaceshipRepository extends JpaRepository<SpaceshipEntity, Long> {

    @CacheEvict(cacheNames = "spaceshipRepository", beforeInvocation = false, key = "#result.id")
    <S extends SpaceshipEntity> S save(S entity);
    @Cacheable("spaceshipRepository")
    @Query("SELECT se FROM SpaceshipEntity se WHERE upper(se.name) LIKE CONCAT('%', :name, '%')")
    Optional<SpaceshipEntity> findByName(@Param("name") String name);
    @Cacheable("spaceshipRepository")
    Optional<SpaceshipEntity> findById(Long id);
    @Cacheable("spaceshipRepository")
    Page<SpaceshipEntity> findAll(Pageable pageable);
    @CacheEvict(cacheNames = "spaceshipRepository", beforeInvocation = false, key = "#result.id")
    void deleteById(Long id);
}
