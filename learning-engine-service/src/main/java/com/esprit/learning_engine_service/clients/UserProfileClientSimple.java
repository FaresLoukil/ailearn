package com.esprit.learning_engine_service.clients;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tn.esprit.spring.commonlib.DTO.UserProfileDTO;

@Service
public class UserProfileClientSimple {

    private final RestTemplate restTemplate;

    public UserProfileClientSimple(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public UserProfileDTO getUserProfile(Long id) {
        String url = "http://localhost:8081/api/userprofiles/" + id;
        return restTemplate.getForObject(url, UserProfileDTO.class);
    }
}

