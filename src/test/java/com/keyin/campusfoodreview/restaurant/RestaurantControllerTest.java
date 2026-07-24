package com.keyin.campusfoodreview.restaurant;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = RestaurantController.class)
public class RestaurantControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private RestaurantService restaurantService;

    @BeforeEach
    void setUp() {
        Mockito.reset(restaurantService);
    }

    @Test
    void getAllRestaurants_returnsOkWithPagedResult() throws Exception {
        List<Restaurant> restaurants = List.of(
                new Restaurant("Restaurant 1", "Address 1", "111-1111"),
                new Restaurant("Restaurant 2", "Address 2", "222-2222")
        );
        Pageable pageable = PageRequest.of(0, 10);
        Page<Restaurant> page = new PageImpl<>(restaurants, pageable, restaurants.size());

        Mockito.when(restaurantService.getAllRestaurants(Mockito.any(Pageable.class))).thenReturn(page);

        mockMvc.perform(get("/api/restaurant"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content.length()").value(2))
                .andExpect(jsonPath("$.content[0].restaurantName").value("Restaurant 1"))
                .andExpect(jsonPath("$.totalElements").value(2));
    }
}
