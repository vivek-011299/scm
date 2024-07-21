package com.scm.repo;

import com.scm.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, String> {
    //write all custom methods here
    Optional<User> findByEmail(String email);
}
