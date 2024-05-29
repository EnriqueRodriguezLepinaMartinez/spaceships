package com.films.spaceship.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Spaceship {

    /**
     * The id
     */
    private Long id;
    /**
     * The name
     */
    private String name;
    /**
     * The film
     */
    private String film;
    /**
     * The date of creation
     */
    private LocalDateTime dateOfCreation;

}
