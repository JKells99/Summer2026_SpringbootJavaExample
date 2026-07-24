package com.keyin.campusfoodreview.campus.dto;

import com.keyin.campusfoodreview.campus.Campus;
import com.keyin.campusfoodreview.restaurant.dto.RestaurantResponseDto;

import java.util.List;

public record CampusResponseDto(Long campusId, String campusName, String campusAddress,
                                 List<RestaurantResponseDto> restaurants) {

    public static CampusResponseDto from(Campus campus) {
        List<RestaurantResponseDto> restaurants = campus.getRestaurants() == null
                ? List.of()
                : campus.getRestaurants().stream().map(RestaurantResponseDto::from).toList();

        return new CampusResponseDto(
                campus.getCampusId(),
                campus.getCampusName(),
                campus.getCampusAddress(),
                restaurants
        );
    }
}
