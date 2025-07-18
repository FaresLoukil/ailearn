package com.esprit.learning_engine_service.clients;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tn.esprit.spring.commonlib.DTO.UserProfileDTO;

@Service
public class UserProfileClientWithCircuitBreaker {

    private final RestTemplate restTemplate;

    public UserProfileClientWithCircuitBreaker(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @CircuitBreaker(name = "userProfileService", fallbackMethod = "fallbackUserProfile")
    public UserProfileDTO getUserProfile(Long id) {
        String url = "http://user-profile-service/api/userprofiles/" + id;
        return restTemplate.getForObject(url, UserProfileDTO.class);
    }

    public UserProfileDTO fallbackUserProfile(Long id, Throwable throwable) {
        // You can log the error or return a default/fake response here
        System.out.println("Fallback triggered for userProfile id: " + id + " due to: " + throwable.getMessage());

        UserProfileDTO fallback = new UserProfileDTO();
        fallback.setId(id);
        fallback.setAddress("Unavailable");
        fallback.setPhoneNumber("Unavailable");
        fallback.setDepartement("Unavailable");
        return fallback;
    }
}

