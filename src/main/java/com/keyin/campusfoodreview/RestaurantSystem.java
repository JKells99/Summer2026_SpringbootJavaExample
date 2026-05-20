package com.keyin.campusfoodreview;

import com.keyin.campusfoodreview.campus.Campus;
import com.keyin.campusfoodreview.restaurant.Restaurant;
import com.keyin.campusfoodreview.review.Review;

public class RestaurantSystem {
    public static void main(String[] args) {
        Restaurant restaurant1 = new Restaurant(1L, "Pizza Place", "123 Main St", "555-1234");
        Restaurant restaurant2 = new Restaurant(2L, "Burger Joint", "456 Elm St", "555-5678");
        Review review1 = new Review(1L, "Great pizza!", 1L);
        Review review2 = new Review(2L, "Delicious burgers!", 2L);
        Review review3 = new Review(3L, "Good service!", 3L);
        Review review4 = new Review(4L, "Excellent atmosphere!", 4L);
        Review review5 = new Review(5L, "Best pizza in town!", 5L);
        Review review6 = new Review(6L, "Best burger in town!", 6L);
        restaurant1.addReview(review1);
        restaurant2.addReview(review2);
        restaurant1.addReview(review3);
        restaurant2.addReview(review4);
        restaurant1.addReview(review5);
        restaurant2.addReview(review6);



        Campus campus1 = new Campus(1L, "Keyin St Johns", "789 University Ave");
        Campus campus2 = new Campus(2L, "University Blvd", "456 Main St");
        campus1.addRestaurant(restaurant1);
        campus2.addRestaurant(restaurant2);

        campus2.addRestaurant(restaurant1);

        System.out.println("Restaurants at " + campus1.getCampusName() + ":");
        campus1.printRestaurantsForCampus();

        System.out.println();

        campus1.searchForRestaurantByRestaurantName("Pizza Place");
        campus1.searchForRestaurantByRestaurantName("Burger Joint");


        System.out.println();

        campus2.printRestaurantsForCampus();
        System.out.println();
        campus2.searchForRestaurantByRestaurantName("Pizza Place");
        System.out.println();
    }
}
