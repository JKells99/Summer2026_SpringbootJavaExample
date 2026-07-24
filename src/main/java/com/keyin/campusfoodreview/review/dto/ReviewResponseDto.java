package com.keyin.campusfoodreview.review.dto;

import com.keyin.campusfoodreview.review.Review;

import java.time.LocalDateTime;

public record ReviewResponseDto(Long reviewId, String reviewText, LocalDateTime reviewDate, Long restaurantId) {

    public static ReviewResponseDto from(Review review) {
        return new ReviewResponseDto(
                review.getReviewId(),
                review.getReviewText(),
                review.getReviewDate(),
                review.getRestaurant() == null ? null : review.getRestaurant().getId()
        );
    }
}
