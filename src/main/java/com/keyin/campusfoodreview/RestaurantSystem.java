package com.keyin.campusfoodreview;

import com.keyin.campusfoodreview.restaurant.Restaurant;
import com.keyin.campusfoodreview.review.Review;

public class RestaurantSystem {
    public static void main(String[] args) {
        Restaurant restaurant1 = new Restaurant(1L, "Pizza Place", "123 Main St", "555-1234");
        Restaurant restaurant2 = new Restaurant(2L, "Burger Joint", "456 Elm St", "555-5678");
        Review review1 = new Review(1L,"Awesome Pizza! ", 1L, 1L);


        restaurant1.addReview(review1);

        System.out.println(restaurant1);
    }
}
