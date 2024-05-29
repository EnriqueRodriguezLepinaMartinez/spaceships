package com.films.spaceship.infrastructure.rest.controller;

import com.films.spaceship.applications.usecases.SpaceshipService;
import com.films.spaceship.domain.dto.SpaceshipDto;
import com.films.spaceship.domain.dto.request.SpaceshipRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/spaceships")
public class SpaceshipController {

    private final SpaceshipService spaceshipService;

    public SpaceshipController(SpaceshipService spaceshipService) {
        this.spaceshipService = spaceshipService;
    }

    @GetMapping("/{id}")
    public SpaceshipDto getById(@PathVariable long id){
        return spaceshipService.getById(id);
    }

    @GetMapping
    public List<SpaceshipDto> getAll() {
        return spaceshipService.getAll();
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
