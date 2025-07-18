package com.esprit.user_profile_service.services;

import com.esprit.user_profile_service.entities.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
    User getById(Long id);
    User save(User user);
    void delete(Long id);
}
