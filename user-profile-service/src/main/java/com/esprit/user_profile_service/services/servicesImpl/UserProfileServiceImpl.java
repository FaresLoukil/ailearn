package com.esprit.user_profile_service.services.servicesImpl;

import com.esprit.user_profile_service.DTO.UserProfileDTO;
import com.esprit.user_profile_service.entities.UserProfile;
import com.esprit.user_profile_service.mapper.UserProfileMapper;
import com.esprit.user_profile_service.repositories.UserProfileRepository;
import com.esprit.user_profile_service.services.UserProfileService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserProfileServiceImpl implements UserProfileService {

    private final UserProfileRepository repo;
    private final UserProfileMapper mapper;

    public UserProfileServiceImpl(UserProfileRepository repo, UserProfileMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    public List<UserProfileDTO> getAll() {
        List<UserProfile> profiles = repo.findAll();
        return mapper.toDTOList(profiles);
    }

    @Override
    public UserProfileDTO getById(Long id) {
        return repo.findById(id)
                .map(mapper::toDTO)
                .orElse(null);
    }

    @Override
    public UserProfileDTO save(UserProfileDTO dto) {
        UserProfile entity = mapper.toEntity(dto);
        UserProfile saved = repo.save(entity);
        return mapper.toDTO(saved);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}

