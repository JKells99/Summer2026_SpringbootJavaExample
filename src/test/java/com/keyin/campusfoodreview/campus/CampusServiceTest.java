package com.keyin.campusfoodreview.campus;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class CampusServiceTest {
    @Mock
    private CampusRepository campusRepository;

    @InjectMocks
    private CampusService campusService;

    Campus campus;
    Campus campus2;
    Campus campus3;
    Campus campus4;
    Campus campus5;

    List<Campus> campuses;

    @BeforeEach
    void setUp() {
        campus = new Campus("Campus 1", "Address 1");
        campus2 = new Campus("Campus 2", "Address 2");
        campus3 = new Campus("Campus 3", "Address 3");
        campus4 = new Campus("Campus 4", "Address 4");
        campus5 = new Campus("Campus 5", "Address 5");
        campuses = List.of(campus, campus2, campus3, campus4, campus5);
    }


    @AfterEach
    void tearDown() {
        campus = null;
        campus2 = null;
        campus3 = null;
        campus4 = null;
        campus5 = null;
        campuses = null;
    }

    @Test
    public void fullListGetsReturned() {
        // Given
        Mockito.when(campusRepository.findAll()).thenReturn(campuses);

        // When
        Iterable<Campus> expected = campusService.getAllCampuses();

        // Then
        Assertions.assertEquals(campuses, expected);
    }

    @Test
    public void getCampusByIdReturnsCorrectCampus() {
        // Given
        Mockito.when(campusRepository.findById(1L)).thenReturn(java.util.Optional.of(campus));

        // When
        java.util.Optional<Campus> expected = campusService.getCampusById(1L);

        // Then
        Assertions.assertTrue(expected.isPresent());
        Assertions.assertEquals(campus, expected.get());
    }


    @Test
    public void saveNewCampusReturnsSavedCampus() {
        // Given
        Mockito.when(campusRepository.save(campus)).thenReturn(campus);

        // When
        Campus expected = campusService.saveCampus(campus);

        // Then
        Assertions.assertEquals(campus, expected);
    }


}

