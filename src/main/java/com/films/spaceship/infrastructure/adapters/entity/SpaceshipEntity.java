package com.films.spaceship.infrastructure.adapters.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "SPACESHIPS")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SpaceshipEntity {

    /**
     * The id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", insertable = false, updatable = false)
    private Long id;
    /**
     * The name
     */
    @Column(name = "NAME")
    private String name;
    /**
     * The film
     */
    @Column(name = "FILM")
    private String film;
    /**
     * The date of creation
     */
    @Column(name = "CREATION_DATE")
    private LocalDateTime dateOfCreation;

}
