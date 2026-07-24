package com.keyin.campusfoodreview.user;

import com.keyin.campusfoodreview.campus.dto.CampusResponseDto;
import com.keyin.campusfoodreview.user.dto.UserResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@CrossOrigin
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;


    @GetMapping("/getAllUsers")
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        List<UserResponseDTO> users = userService.getAllUsers().stream()
                .map(UserResponseDTO::from)
                .collect(toList());
        return ResponseEntity.ok(users);
    }

    @PostMapping("/createUser")
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody User user) {
        User savedUser = userService.saveNewUser(user);
        return ResponseEntity.ok(UserResponseDTO.from(savedUser));

    }
    @GetMapping("/getUserById/{userId}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable Long userId) {
        User user = userService.getUserById(userId);
        return ResponseEntity.ok(UserResponseDTO.from(user));
    }
}
