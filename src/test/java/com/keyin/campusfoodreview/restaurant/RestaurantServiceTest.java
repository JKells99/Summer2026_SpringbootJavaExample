package com.keyin.campusfoodreview.restaurant;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class RestaurantServiceTest {
    @Mock
    private RestaurantRepository restaurantRepository;

    @InjectMocks
    private RestaurantService restaurantService;

    Restaurant restaurant;
    Restaurant restaurant2;
    List<Restaurant> restaurants;

    @BeforeEach
    void setUp() {
        restaurant = new Restaurant("Restaurant 1", "Address 1", "111-1111");
        restaurant2 = new Restaurant("Restaurant 2", "Address 2", "222-2222");
        restaurants = List.of(restaurant, restaurant2);
    }

    @AfterEach
    void tearDown() {
        restaurant = null;
        restaurant2 = null;
        restaurants = null;
    }

    @Test
    public void getAllRestaurantsReturnsPagedResult() {
        Pageable pageable = PageRequest.of(0, 10);
        Page<Restaurant> page = new PageImpl<>(restaurants, pageable, restaurants.size());
        Mockito.when(restaurantRepository.findAll(pageable)).thenReturn(page);

        Page<Restaurant> expected = restaurantService.getAllRestaurants(pageable);

        Assertions.assertEquals(restaurants, expected.getContent());
        Assertions.assertEquals(2, expected.getTotalElements());
    }

    @Test
    public void saveNewRestaurantReturnsSavedRestaurant() {
        Mockito.when(restaurantRepository.save(restaurant)).thenReturn(restaurant);

        Restaurant expected = restaurantService.saveRestaurant(restaurant);

        Assertions.assertEquals(restaurant, expected);
    }
}
