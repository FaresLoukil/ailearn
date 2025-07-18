package com.esprit.learning_engine_service.controllers;

import com.esprit.learning_engine_service.clients.UserProfileClientWithCircuitBreaker;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.commonlib.DTO.UserProfileDTO;

@RestController
@RequestMapping("/userprofile-client/cb")
public class UserProfileCircuitBreakerController {

    private final UserProfileClientWithCircuitBreaker cbClient;

    public UserProfileCircuitBreakerController(UserProfileClientWithCircuitBreaker cbClient) {
        this.cbClient = cbClient;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserProfileWithCircuitBreaker(@PathVariable Long id) {
        try {
            UserProfileDTO profile = cbClient.getUserProfile(id);
            return ResponseEntity.ok(profile);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error calling user-profile-service: " + e.getMessage());
        }
    }
}
