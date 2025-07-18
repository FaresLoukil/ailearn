package com.esprit.user_profile_service.services;


import com.esprit.user_profile_service.DTO.UserProfileDTO;

import java.util.List;

public interface UserProfileService {
    List<UserProfileDTO> getAll();
    UserProfileDTO getById(Long id);
    UserProfileDTO save(UserProfileDTO dto);
    void delete(Long id);
}
