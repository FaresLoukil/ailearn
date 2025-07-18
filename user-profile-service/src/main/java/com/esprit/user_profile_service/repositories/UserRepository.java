package com.esprit.user_profile_service.repositories;

import com.esprit.user_profile_service.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
