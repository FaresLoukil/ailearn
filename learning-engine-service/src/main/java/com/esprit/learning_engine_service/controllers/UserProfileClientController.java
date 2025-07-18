package com.esprit.learning_engine_service.controllers;

import com.esprit.learning_engine_service.clients.UserProfileClientSimple;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.spring.commonlib.DTO.UserProfileDTO;

@RestController
@RequestMapping("/userprofile-client")
public class UserProfileClientController {

    private final UserProfileClientSimple userProfileClientSimple;

    public UserProfileClientController(UserProfileClientSimple userProfileClientSimple) {
        this.userProfileClientSimple = userProfileClientSimple;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserProfile(@PathVariable Long id) {
        try {
            UserProfileDTO profile = userProfileClientSimple.getUserProfile(id);
            return ResponseEntity.ok(profile);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error calling user-profile-service: " + e.getMessage());
        }
    }

}
