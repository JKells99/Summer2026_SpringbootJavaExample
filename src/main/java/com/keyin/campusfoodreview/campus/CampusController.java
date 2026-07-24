package com.keyin.campusfoodreview.campus;

import com.keyin.campusfoodreview.campus.dto.CampusRequestDto;
import com.keyin.campusfoodreview.campus.dto.CampusResponseDto;
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
    public CampusResponseDto addCampus(@RequestBody CampusRequestDto campusRequestDto){
        Campus campus = new Campus(campusRequestDto.campusName(), campusRequestDto.campusAddress());
        return CampusResponseDto.from(campusService.saveCampus(campus));
    }

    @GetMapping("/getAllCampuses")
    public ResponseEntity<List<CampusResponseDto>> getAllCampuses() {
        List<CampusResponseDto> campuses = campusService.getAllCampuses().stream()
                .map(CampusResponseDto::from)
                .toList();
        return ResponseEntity.ok(campuses);
    }

    @GetMapping("/getCampusById/{id}")
    public ResponseEntity<CampusResponseDto> getCampusById(@PathVariable long id) {
        Optional<Campus> campus = campusService.getCampusById(id);
        return campus.map(value -> ResponseEntity.ok(CampusResponseDto.from(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping("/seed")
    public ResponseEntity<List<CampusResponseDto>> seedCampuses() {
        List<CampusResponseDto> campuses = campusService.seedCampuses().stream()
                .map(CampusResponseDto::from)
                .toList();
        return new ResponseEntity<>(campuses, HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCampusById(@PathVariable long id) {
        campusService.deleteById(id);
        return new ResponseEntity<String>("Campus with id " + id + " has been deleted", HttpStatus.OK);
    }
    @PutMapping("/{campusId}/addRestaurantToCampus/{restaurantId}")
    public ResponseEntity<String> addRestaurantToCampus(@PathVariable Long campusId, @PathVariable Long restaurantId) {
        return new ResponseEntity<String>(campusService.addRestaurantToCampus(campusId, restaurantId), HttpStatus.OK);
    }

}
