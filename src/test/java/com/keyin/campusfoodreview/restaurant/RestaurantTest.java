package com.keyin.campusfoodreview.restaurant;

import com.keyin.campusfoodreview.review.Review;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RestaurantTest {

    Restaurant restaurant;

    @BeforeEach
    void setUp() {
        restaurant = new Restaurant("Pizza Place", "123 Main St", "555-1234");
    }
    @AfterEach
    void tearDown() {
        restaurant = null;
    }

    @Test
    void testRestaurantCreation() {
        Assertions.assertEquals("Pizza Place", restaurant.getRestaurantName());
        Assertions.assertEquals("123 Main St", restaurant.getRestaurantAddress());
        Assertions.assertNotEquals("Pizza Placce", restaurant.getRestaurantPhone());
    }

    @Test
    void testRestaurantSetters() {
        restaurant.setRestaurantName("Burger Joint");
        restaurant.setRestaurantAddress("456 Elm St");
        restaurant.setRestaurantPhone("555-5678");

        Assertions.assertEquals("Burger Joint", restaurant.getRestaurantName());
        Assertions.assertEquals("456 Elm St", restaurant.getRestaurantAddress());
        Assertions.assertEquals("555-5678", restaurant.getRestaurantPhone());
    }

    @Test
    void testAddingReviewToRestaurant(){
        Review review = new Review("Great pizza!", 1L);
        restaurant.addReview(review);
        Assertions.assertEquals(1,restaurant.getReviews().size());
    }
}
