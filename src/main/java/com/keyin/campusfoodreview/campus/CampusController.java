package com.keyin.campusfoodreview.campus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/campus")
public class CampusController {

    @Autowired
    CampusService campusService;

    @PostMapping("/add")
    public Campus addCampus(@RequestBody Campus campus){
        return campusService.saveCampus(campus);
    }

    @GetMapping("/getAllCampuses")
    public ResponseEntity<List<Campus>> getAllCampuses() {
        return ResponseEntity.ok(campusService.getAllCampuses());
    }


    @GetMapping("/getCampusById/{id}")
    public ResponseEntity<Optional<Campus>> getCampusById(@PathVariable long id) {
        return new ResponseEntity<Optional<Campus>>(campusService.getCampusById(id), HttpStatus.OK);

    }


    @PostMapping("/seed")
    public ResponseEntity<List<Campus>> seedCampuses() {
        return new ResponseEntity<>(campusService.seedCampuses(), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCampusById(@PathVariable long id) {

        campusService.deleteById(id);

        return new ResponseEntity<String>("Campus with id " + id + " has been deleted", HttpStatus.OK);

    }





}
