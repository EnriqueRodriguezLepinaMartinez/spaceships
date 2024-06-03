package com.films.spaceship.applications.service;

import com.films.spaceship.applications.mapper.SpaceshipDtoMapper;
import com.films.spaceship.applications.mapper.SpaceshipRequestMapper;
import com.films.spaceship.domain.dto.request.SpaceshipRequest;
import com.films.spaceship.domain.model.Spaceship;
import com.films.spaceship.domain.port.SpaceshipPersistencePort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SpaceshipManagementServiceTest {

    @InjectMocks
    SpaceshipManagementService spaceshipManagementService;
    @Mock
    SpaceshipPersistencePort spaceshipPersistencePort;
    @Mock
    SpaceshipRequestMapper spaceshipRequestMapper;
    @Mock
    SpaceshipDtoMapper spaceshipDtoMapper;
    SpaceshipRequest request = new SpaceshipRequest("nameTest", "filmTest");
    Spaceship response = new Spaceship(Long.parseLong("1"),"nameTest","filmTest",new Date());

    @Test
    void GIVEN_SpaceshipRequest_WHEN_createNew_THEN_SpaceshipDto() {
        when(spaceshipRequestMapper.toDomain(request)).thenReturn(response);
        when(spaceshipPersistencePort.create(any())).thenReturn(response);
        assertNotNull(spaceshipManagementService.createNew(request));
    }

    @Test
    void GIVEN_Name_WHEN_getByName_THEN_SpaceshipDto() {
        when(spaceshipPersistencePort.getByName(any())).thenReturn(response);
        assertNotNull(spaceshipManagementService.getByName("nameTest"));
    }

    @Test
    void GIVEN_Id_WHEN_getById_THEN_SpaceshipDto() {
        when(spaceshipPersistencePort.getById(any())).thenReturn(response);
        assertNotNull(spaceshipManagementService.getById(Long.parseLong("1")));
    }

    @Test
    void GIVEN_Pageable_WHEN_getAll_THEN_Page_of_SpaceshipDto() {
        when(spaceshipPersistencePort.getAll(any())).thenReturn(new PageImpl<>(List.of(response)));
        Pageable pageable = mock(Pageable.class);
        assertNotNull(spaceshipManagementService.getAll(pageable));
    }

    @Test
    void GIVEN_Id_WHEN_deleteById_THEN_Void() {
        doNothing().when(spaceshipPersistencePort).deleteById(any());
        spaceshipManagementService.deleteById(Long.parseLong("1"));
    }

    @Test
    void GIVEN_SpaceshipRequest_and_Id_WHEN_update_THEN_SpaceshipDto() {
        when(spaceshipPersistencePort.update(any())).thenReturn(response);
        assertNotNull(spaceshipManagementService.update(request,Long.parseLong("1")));
    }
}
