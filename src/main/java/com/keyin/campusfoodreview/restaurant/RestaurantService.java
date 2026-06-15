package com.keyin.campusfoodreview.restaurant;


import com.keyin.campusfoodreview.campus.Campus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    RestaurantRepository restaurantRepository;

    public Restaurant saveRestaurant(Restaurant restaurant){
        return restaurantRepository.save(restaurant);
    }
    public Iterable<Restaurant> getAllRestaurants(){
        return restaurantRepository.findAll();
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


//    public List<Campus> seedCampuses() {
//        List<Campus> campuses = List.of(
//                new Campus("Keyin College - St. John's", "45 Stavanger Dr, St. John's, NL A1A 5E8"),
//                new Campus("Keyin College - Corner Brook", "48 West St, Corner Brook, NL A2H 2Z2"),
//                new Campus("Keyin College - Carbonear", "4 Robert Parsons Dr, Carbonear, NL A1Y 1B2"),
//                new Campus("Keyin College - Grand Falls-Windsor", "7 Hardy Ave, Grand Falls-Windsor, NL A2A 1X3"),
//                new Campus("Keyin College - Gander", "100 Trans-Canada Hwy, Gander, NL A1V 1P5")
//        );
//        return campusRepository.saveAll(campuses);
//    }



