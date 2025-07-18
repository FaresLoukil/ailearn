package com.esprit.user_profile_service.mapper;


import com.esprit.user_profile_service.DTO.UserProfileDTO;
import com.esprit.user_profile_service.entities.UserProfile;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserProfileMapper {
    UserProfileDTO toDTO(UserProfile entity);
    UserProfile toEntity(UserProfileDTO dto);
    List<UserProfileDTO> toDTOList(List<UserProfile> entities);
}

