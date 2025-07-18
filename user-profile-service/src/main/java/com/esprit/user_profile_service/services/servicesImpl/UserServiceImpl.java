package com.esprit.user_profile_service.services.servicesImpl;

import com.esprit.user_profile_service.entities.User;
import com.esprit.user_profile_service.repositories.UserRepository;
import com.esprit.user_profile_service.services.UserService;
import org.springframework.stereotype.Service;
import tn.esprit.spring.commonlib.exceptions.ResourceNotFoundException;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repo;

    public UserServiceImpl(UserRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<User> getAll() {
        return repo.findAll();
    }

    @Override
    public User getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
    }

    @Override
    public User save(User user) {
        return repo.save(user);
    }

    @Override
    public void delete(Long id) {
        if (!repo.existsById(id)) {
            throw new ResourceNotFoundException("User not found with id: " + id);
        }
        repo.deleteById(id);
    }
}
