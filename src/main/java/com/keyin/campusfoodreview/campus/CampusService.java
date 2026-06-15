package com.keyin.campusfoodreview.campus;

import com.keyin.campusfoodreview.restaurant.Restaurant;
import com.keyin.campusfoodreview.restaurant.RestaurantRepository;
import com.keyin.campusfoodreview.restaurant.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CampusService {
    // Why is this not recommended??
    @Autowired
    CampusRepository campusRepository;

    @Autowired
    RestaurantRepository restaurantRepository;

    public Campus saveCampus(Campus campus){
        return campusRepository.save(campus);
    }


    public List<Campus> getAllCampuses() {
        return campusRepository.findAll();
    }


    public Optional<Campus> getCampusById(long id) {
        return campusRepository.findById(id);
    }

    public void deleteById(long id) {
        campusRepository.deleteById(id);
    }

    public List<Campus> seedCampuses() {
        List<Campus> campuses = List.of(
            new Campus("Keyin College - St. John's", "45 Stavanger Dr, St. John's, NL A1A 5E8"),
            new Campus("Keyin College - Corner Brook", "48 West St, Corner Brook, NL A2H 2Z2"),
            new Campus("Keyin College - Carbonear", "4 Robert Parsons Dr, Carbonear, NL A1Y 1B2"),
            new Campus("Keyin College - Grand Falls-Windsor", "7 Hardy Ave, Grand Falls-Windsor, NL A2A 1X3"),
            new Campus("Keyin College - Gander", "100 Trans-Canada Hwy, Gander, NL A1V 1P5")
        );
        return campusRepository.saveAll(campuses);
    }

    public String addRestaurantToCampus(Long campusId, Long restaurantId) {

        Optional<Campus> foundCampus = campusRepository.findById(campusId);

        Optional<Restaurant> foundRestaurant = restaurantRepository.findById(restaurantId);

        if (foundCampus.isPresent() && foundRestaurant.isPresent()) {
            Campus campus = foundCampus.get();
            Restaurant restaurant = foundRestaurant.get();
            campus.getRestaurants().add(restaurant);
            campusRepository.save(campus);
            return "Restaurant " + restaurant.getRestaurantName() + " has been added to campus " + campus.getCampusName();
        } else {
            return "Campus or Restaurant not found";
        }


    }
}
