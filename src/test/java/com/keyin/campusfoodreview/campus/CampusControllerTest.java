package com.keyin.campusfoodreview.campus;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = CampusController.class)
public class CampusControllerTest {
    @Autowired
    private MockMvc mockMvc;
   @MockitoBean
    private CampusService campusService;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUp() {
        Mockito.reset(campusService);
    }


    @Test
    void getAllCampuses_returnsOkWithList() throws Exception {
        List<Campus> campuses = List.of(
                new Campus("Campus 1", "Address 1"),
                new Campus("Campus 2", "Address 2")
        );

        Mockito.when(campusService.getAllCampuses()).thenReturn(campuses);

        mockMvc.perform(get("/api/campus/getAllCampuses"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].campusName").value("Campus 1"));
    }



}

//package com.keyin.trail;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.bean.override.mockito.MockitoBean;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.util.List;
//import java.util.Optional;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//        import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//@WebMvcTest(TrailController.class)
//public class TrailControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockitoBean
//    private TrailService trailService;
//
//    private final ObjectMapper objectMapper = new ObjectMapper();
//
//    @Test
//    void getAllTrails_returnsOkWithList() throws Exception {
//        List<Trail> trails = List.of(
//                new Trail(1L, "Trail 1", "Location 1", 10.0, "Easy", true),
//                new Trail(2L, "Trail 2", "Location 2", 15.0, "Medium", true)
//        );
//
//        Mockito.when(trailService.getAllTrails()).thenReturn(trails);
//
//        mockMvc.perform(get("/trails"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.length()").value(2))
//                .andExpect(jsonPath("$[0].name").value("Trail 1"));
//    }
//
//    @Test
//    void addNewTrail_returnsOkWithSavedTrail() throws Exception {
//        Trail trail = new Trail(1L, "Trail 1", "Location 1", 10.0, "Easy", true);
//
//        Mockito.when(trailService.saveTrail(Mockito.any(Trail.class))).thenReturn(trail);
//
//        mockMvc.perform(post("/trails")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(trail)))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.name").value("Trail 1"));
//    }
//
//    @Test
//    void getTrailById_returnsOkWhenFound() throws Exception {
//        Mockito.when(trailService.getTrailById(1L)).thenReturn(Optional.of(
//                new Trail(1L, "Trail 1", "Location 1", 10.0, "Easy", true)
//        ));
//
//        mockMvc.perform(get("/trails/1").param("id", "1"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.name").value("Trail 1"));
//    }
//}

