package com.keyin.campusfoodreview.restaurant;

import com.keyin.campusfoodreview.restaurant.dto.RestaurantRequestDto;
import com.keyin.campusfoodreview.restaurant.dto.RestaurantResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/restaurant")
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;

    @PostMapping("/seedData")
    public ResponseEntity<Iterable<RestaurantResponseDto>> seedData() {
        Iterable<RestaurantResponseDto> restaurants = restaurantService.seedRestaurants().stream()
                .map(RestaurantResponseDto::from)
                .toList();
        return ResponseEntity.ok(restaurants);
    }

    @GetMapping
    public ResponseEntity<Page<RestaurantResponseDto>> getAllRestaurants(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<RestaurantResponseDto> restaurants = restaurantService.getAllRestaurants(pageable)
                .map(RestaurantResponseDto::from);
        return ResponseEntity.ok(restaurants);
    }

    @PostMapping
    public ResponseEntity<RestaurantResponseDto> createNewRestaurant(@RequestBody RestaurantRequestDto restaurantRequestDto) {
        Restaurant restaurant = new Restaurant(
                restaurantRequestDto.restaurantName(),
                restaurantRequestDto.restaurantAddress(),
                restaurantRequestDto.restaurantPhone()
        );
        Restaurant saved = restaurantService.saveRestaurant(restaurant);
        return ResponseEntity.status(HttpStatus.CREATED).body(RestaurantResponseDto.from(saved));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRestaurant(@PathVariable Long id) {
        restaurantService.deleteRestaurantById(id);
        return ResponseEntity.ok("Restaurant with id " + id + " has been deleted");
    }
}
