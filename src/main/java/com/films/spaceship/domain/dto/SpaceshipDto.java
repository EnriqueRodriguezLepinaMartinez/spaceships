package com.films.spaceship.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SpaceshipDto {

    /**
     * The id
     */
    @Schema(example = "1", description = "id this object")
    private Long id;
    /**
     * The name
     */
    @Schema(example = "Millennium Falcon", description = "name from spacehsip")
    private String name;
    /**
     * The film
     */
    @Schema(example = "Star Wars", description = "film from is")
    private String film;
    /**
     * The date of creation
     */
    @Schema(example = "28/05/2024", description = "date added in db")
    private LocalDateTime dateOfCreation;

}
