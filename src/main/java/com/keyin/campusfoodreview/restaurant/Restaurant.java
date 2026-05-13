package com.keyin.campusfoodreview.restaurant;

import com.keyin.campusfoodreview.review.Review;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    // What does restaurant need?
    private Long id;
    private String restaurantName;
    private String restaurantAddress;
    private String restaurantPhone;

    private List<Review> reviews;

    public Restaurant(Long id, String restaurantName, String restaurantAddress, String restaurantPhone) {
        this.id = id;
        this.restaurantName = restaurantName;
        this.restaurantAddress = restaurantAddress;
        this.restaurantPhone = restaurantPhone;
        reviews = new ArrayList<>();
    }

    public Restaurant(String restaurantName, String restaurantAddress, String restaurantPhone) {
        this.restaurantName = restaurantName;
        this.restaurantAddress = restaurantAddress;
        this.restaurantPhone = restaurantPhone;
        reviews = new ArrayList<>();
    }

    public Restaurant() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getRestaurantAddress() {
        return restaurantAddress;
    }

    public void setRestaurantAddress(String restaurantAddress) {
        this.restaurantAddress = restaurantAddress;
    }

    public String getRestaurantPhone() {
        return restaurantPhone;
    }

    public void setRestaurantPhone(String restaurantPhone) {
        this.restaurantPhone = restaurantPhone;
    }

    public void addReview(Review review) {
        reviews.add(review);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Restaurant{");
        sb.append("id=").append(id);
        sb.append(", restaurantName='").append(restaurantName).append('\'');
        sb.append(", restaurantAddress='").append(restaurantAddress).append('\'');
        sb.append(", restaurantPhone='").append(restaurantPhone).append('\'');
        sb.append(", reviews=").append(reviews);
        sb.append('}');
        return sb.toString();
    }
}
