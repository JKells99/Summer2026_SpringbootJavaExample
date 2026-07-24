package com.keyin.campusfoodreview.restaurant;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    RestaurantRepository restaurantRepository;

    public Restaurant saveRestaurant(Restaurant restaurant){
        return restaurantRepository.save(restaurant);
    }
    public Page<Restaurant> getAllRestaurants(Pageable pageable){
        return restaurantRepository.findAll(pageable);
    }
    public Restaurant getRestaurantById(long id){
        return restaurantRepository.findById(id).get();
    }
    public void deleteRestaurantById(long id){
        restaurantRepository.deleteById(id);
    }

    public List<Restaurant> seedRestaurants(){
        List<Restaurant> restaurants = List.of(
                new Restaurant("Pizza Delight", "123 Main St, St. John's, NL A1A 1A1", "Pizza"),
                new Restaurant("Subway", "456 Elm St, St. John's, NL A1A 2B2", "Sandwiches"),
                new Restaurant("Tim Hortons", "789 Oak St, St. John's, NL A1A 3C3", "Coffee and Donuts"),
                new Restaurant("McDonald's", "321 Maple St, St. John's, NL A1A 4D4", "Fast Food"),
                new Restaurant("KFC", "654 Pine St, St. John's, NL A1A 5E5", "Fried Chicken")


        );
        return restaurantRepository.saveAll(restaurants);

}}
