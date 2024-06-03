package com.films.spaceship.infrastructure.rest.controller;

import com.films.spaceship.applications.usecases.SpaceshipService;
import com.films.spaceship.domain.dto.SpaceshipDto;
import com.films.spaceship.domain.dto.request.SpaceshipRequest;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name="Spaceships", description = "Endpoints for the spaceships management")
@RestController
@RequestMapping("/spaceships")
public class SpaceshipController {

    private final SpaceshipService spaceshipService;

    public SpaceshipController(SpaceshipService spaceshipService) {
        this.spaceshipService = spaceshipService;
    }

    @GetMapping("name/{name}")
    public SpaceshipDto getByName(@PathVariable String name){
        return spaceshipService.getByName(name);
    }

    @GetMapping("id/{id}")
    public SpaceshipDto getById(@PathVariable long id){
        return spaceshipService.getById(id);
    }

    @GetMapping
    public Page<SpaceshipDto> getAll(Pageable pageable) {
        return spaceshipService.getAll(pageable);
    }

    @PostMapping()
    public SpaceshipDto create(@RequestBody SpaceshipRequest spaceshipRequest){
        return spaceshipService.createNew(spaceshipRequest);
    }

    @PutMapping("/{id}")
    public SpaceshipDto spaceshipEdit(@RequestBody SpaceshipRequest spaceshipRequest,
                               @PathVariable Long id){
        return spaceshipService.update(spaceshipRequest, id);
    }

    @DeleteMapping("/{id}")
    public void deleteSpaceshipById(@PathVariable Long id){
        spaceshipService.deleteById(id);
    }

}
