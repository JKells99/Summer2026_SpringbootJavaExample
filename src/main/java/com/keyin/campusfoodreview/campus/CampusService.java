package com.keyin.campusfoodreview.campus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CampusService {
    // Why is this not recommended??
    @Autowired
    CampusRepository campusRepository;

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
}
