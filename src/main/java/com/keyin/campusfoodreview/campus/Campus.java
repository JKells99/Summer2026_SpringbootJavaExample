package com.keyin.campusfoodreview.campus;

import com.keyin.campusfoodreview.restaurant.Restaurant;
import com.keyin.campusfoodreview.review.Review;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Campus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long campusId;
    private String campusName;
    private String campusAddress;

    @OneToMany
    private List<Restaurant> restaurants;

    public Campus() {
    }

    public Campus(String campusName, String campusAddress) {
        this.campusName = campusName;
        this.campusAddress = campusAddress;
        this.restaurants = new ArrayList<>();
    }

    public Campus(Long campusId, String campusName, String campusAddress, List<Restaurant> restaurants) {
        this.campusId = campusId;
        this.campusName = campusName;
        this.campusAddress = campusAddress;
        this.restaurants = restaurants;
    }

    public Long getCampusId() {
        return campusId;
    }

    public void setCampusId(Long campusId) {
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

}
