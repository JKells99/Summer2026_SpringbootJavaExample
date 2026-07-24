package com.keyin.campusfoodreview.user.dto;

import com.keyin.campusfoodreview.user.User;

public record UserResponseDTO(String username, String email) {

    public static UserResponseDTO from(User user) {
        return new UserResponseDTO(
                user.getUsername(),
                user.getEmail()
        );
    }
}