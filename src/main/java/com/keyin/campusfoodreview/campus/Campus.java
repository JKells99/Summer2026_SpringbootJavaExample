package com.keyin.campusfoodreview.campus;

import com.keyin.campusfoodreview.restaurant.Restaurant;
import com.keyin.campusfoodreview.review.Review;

import java.util.ArrayList;
import java.util.List;

public class Campus {
    private long campusId;
    private String campusName;
    private String campusAddress;
    private List<Restaurant> restaurants;

    public Campus(long campusId, String campusName, String campusAddress) {
        this.campusId = campusId;
        this.campusName = campusName;
        this.campusAddress = campusAddress;
        this.restaurants = new ArrayList<>();
    }

    public Campus(String campusName, String campusAddress) {
        this.campusName = campusName;
        this.campusAddress = campusAddress;
        this.restaurants = new ArrayList<>();
    }

    public Campus() {
    }

    public long getCampusId() {
        return campusId;
    }

    public void setCampusId(long campusId) {
        this.campusId = campusId;
    }

    public String getCampusName() {
        return campusName;
    }

    public void setCampusName(String campusName) {
        this.campusName = campusName;
    }

    public String getCampusAddress() {
        return campusAddress;
    }

    public void setCampusAddress(String campusAddress) {
        this.campusAddress = campusAddress;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    public void addRestaurant(Restaurant restaurant) {
        restaurants.add(restaurant);
    }

    public void removeRestaurant(Restaurant restaurant) {
        restaurants.remove(restaurant);
    }



    public void printRestaurantsForCampus() {
        System.out.println("Restaurants on " + campusName + ":");
        for (Restaurant restaurant : restaurants) {
            System.out.println("- " + restaurant.getRestaurantName());
        }
    }

    public void searchForRestaurantByRestaurantName(String restaurantName) {
        for (Restaurant restaurant : restaurants) {
            if (restaurant.getRestaurantName().equalsIgnoreCase(restaurantName)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Restaurant found: ").append(restaurant.getRestaurantName()).append("\n");
                sb.append("Address: ").append(restaurant.getRestaurantAddress()).append("\n");
                sb.append("Phone: ").append(restaurant.getRestaurantPhone()).append("\n");

                List<Review> reviews = restaurant.getReviews();
                sb.append("Reviews:\n");
                for (Review review : reviews) {
                    sb.append("- ").append(review).append("\n");
                }

                System.out.print(sb);
                return;
            }
        }
        System.out.println("Restaurant not found.");
    }



    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Campus{");
        sb.append("campusId=").append(campusId);
        sb.append(", campusName='").append(campusName).append('\'');
        sb.append(", campusAddress='").append(campusAddress).append('\'');
        sb.append(", restaurants=").append(restaurants);
        sb.append('}');
        return sb.toString();
    }
}
