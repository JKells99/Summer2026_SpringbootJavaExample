package com.keyin.campusfoodreview.review;

import com.keyin.campusfoodreview.restaurant.Restaurant;

import java.time.LocalDateTime;

public class Review {
    private Long reviewId;
    private String reviewText;
    private LocalDateTime reviewDate;
    private Long restaurantId;
    private Long userId;

    public Review(Long reviewId, String reviewText, Long restaurantId, Long userId) {
        this.reviewId = reviewId;
        this.reviewText = reviewText;
        this.reviewDate = LocalDateTime.now();
        this.restaurantId = restaurantId;
        this.userId = userId;
    }

    public Review(String reviewText, Long restaurantId, Long userId) {
        this.reviewText = reviewText;
        this.reviewDate = LocalDateTime.now();
        this.restaurantId = restaurantId;
        this.userId = userId;
    }

    public Review() {
    }

    public Long getReviewId() {
        return reviewId;
    }

    public void setReviewId(Long reviewId) {
        this.reviewId = reviewId;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public LocalDateTime getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(LocalDateTime reviewDate) {
        this.reviewDate = reviewDate;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Review{");
        sb.append("reviewId=").append(reviewId);
        sb.append(", reviewText='").append(reviewText).append('\'');
        sb.append(", reviewDate=").append(reviewDate);
        sb.append(", restaurantId=").append(restaurantId);
        sb.append(", userId=").append(userId);
        sb.append('}');
        return sb.toString();
    }
}
