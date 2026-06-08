package com.keyin.campusfoodreview.campus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/campus")
public class CampusController {

    @Autowired
    CampusService campusService;

    @PostMapping("/add")
    public Campus addCampus(@RequestBody Campus campus){
        return campusService.saveCampus(campus);
    }



}
