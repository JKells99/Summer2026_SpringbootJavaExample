package com.keyin.campusfoodreview.restaurant.dto;

import com.keyin.campusfoodreview.restaurant.Restaurant;
import com.keyin.campusfoodreview.review.dto.ReviewResponseDto;

public record RestaurantResponseDto(Long id, String restaurantName, String restaurantAddress, String restaurantPhone, java.util.List<ReviewResponseDto> reviews) {

    public static RestaurantResponseDto from(Restaurant restaurant) {
        java.util.List<ReviewResponseDto> reviews = restaurant.getReviews() == null
                ? java.util.List.of()
                : restaurant.getReviews().stream().map(ReviewResponseDto::from).toList();

        return new RestaurantResponseDto(
                restaurant.getId(),
                restaurant.getRestaurantName(),
                restaurant.getRestaurantAddress(),
                restaurant.getRestaurantPhone(),
                reviews
        );
    }
}
