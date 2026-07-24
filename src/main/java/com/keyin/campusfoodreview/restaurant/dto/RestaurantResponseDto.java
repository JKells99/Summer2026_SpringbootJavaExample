package com.keyin.campusfoodreview.restaurant.dto;

import com.keyin.campusfoodreview.restaurant.Restaurant;

public record RestaurantResponseDto(Long id, String restaurantName, String restaurantAddress, String restaurantPhone) {

    public static RestaurantResponseDto from(Restaurant restaurant) {
        return new RestaurantResponseDto(
                restaurant.getId(),
                restaurant.getRestaurantName(),
                restaurant.getRestaurantAddress(),
                restaurant.getRestaurantPhone()
        );
    }
}
