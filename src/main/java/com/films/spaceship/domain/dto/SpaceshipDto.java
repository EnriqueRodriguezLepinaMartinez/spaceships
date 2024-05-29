package com.films.spaceship.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

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
    @Schema(example = "28-05-2024 18:32", description = "date added in db")
    @JsonFormat(pattern="dd-MM-yyyy HH:mm")
    private Date dateOfCreation;

}
