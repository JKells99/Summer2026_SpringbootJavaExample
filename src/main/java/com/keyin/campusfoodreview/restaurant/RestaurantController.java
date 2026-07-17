package com.keyin.campusfoodreview.restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/restaurant")
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;

    @PostMapping("/seedData")
    public ResponseEntity<Iterable<Restaurant>> seedData() {
        return ResponseEntity.ok(restaurantService.seedRestaurants());
    }

    @GetMapping
    public ResponseEntity<Iterable<Restaurant>> getAllRestaurants() {
        return ResponseEntity.ok(restaurantService.getAllRestaurants());
    }

    @PostMapping
    public ResponseEntity<String> createNewRestaurant(@RequestBody Restaurant restaurant) {
        restaurantService.saveRestaurant(restaurant);
        return ResponseEntity.ok("Restaurant created successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRestaurant(@PathVariable Long id) {
        restaurantService.deleteRestaurantById(id);
        return ResponseEntity.ok("Restaurant with id " + id + " has been deleted");
    }
}
