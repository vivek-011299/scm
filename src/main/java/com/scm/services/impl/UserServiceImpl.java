package com.scm.services.impl;

import com.scm.model.User;
import com.scm.repo.UserRepo;
import com.scm.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;
    @Override
    public User saveUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public Optional<User> getUserById(String id) {
        return userRepo.findById(id);
    }

    @Override
    public void deleteUser(String id) {

    }

    @Override
    public Optional<User> updateUser(User user) {
        return Optional.empty();
    }

    @Override
    public boolean userExistsByEmail(String email) {
        return false;
    }

    @Override
    public boolean userExistsById(String id) {
        return false;
    }

    @Override
    public Optional<List<User>> getAllUsers() {
        return Optional.empty();
    }
}
