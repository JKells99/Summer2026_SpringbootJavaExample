package com.keyin.campusfoodreview;

import com.keyin.campusfoodreview.restaurant.Restaurant;

public class RestaurantSystem {
    public static void main(String[] args) {
        Restaurant restaurant1 = new Restaurant(1L, "Pizza Place", "123 Main St", "555-1234");
        Restaurant restaurant2 = new Restaurant(2L, "Burger Joint", "456 Elm St", "555-5678");
        System.out.println(restaurant1);
        System.out.println(restaurant2);
    }
}
