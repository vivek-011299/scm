package com.scm.services.impl;

import com.scm.helpers.ResourceNotFoundException;
import com.scm.model.User;
import com.scm.repo.UserRepo;
import com.scm.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;
    @Override
    public User saveUser(User user) {
        //We have to generate user_id by ourself
        String user_id = UUID.randomUUID().toString();
        user.setUserId(user_id);
        return userRepo.save(user);
    }

    @Override
    public Optional<User> getUserById(String id) {
        return userRepo.findById(id);
    }

    @Override
    public void deleteUser(String id) {
        User user_to_delete = userRepo.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("User not found"));
        userRepo.delete(user_to_delete);
    }

    @Override
    public Optional<User> updateUser(User user) {

       User user_found = userRepo.findById(user.getUserId()).orElseThrow(()->
               new ResourceNotFoundException("User not found"));
       user_found.setName(user.getName());
       user_found.setProfilePic(user.getProfilePic());
       user_found.setPhoneNumber(user.getPhoneNumber());
       user_found.setPassword(user.getPassword());
       user_found.setEmail(user.getEmail());
       user_found.setAbout(user.getAbout());
       user_found.setName(user.getName());
       user_found.setPhoneVerified(user.isPhoneVerified());
       user_found.setEnabled(user.isEnabled());
       user_found.setEmailVerified(user.isEmailVerified());

       User updated_user = userRepo.save(user_found);
       return Optional.ofNullable(updated_user);

    }

    @Override
    public boolean userExistsByEmail(String email) {
    User user_to_find = userRepo.findByEmail(email).orElse(null);
    return user_to_find!=null ? true : false;
    }

    @Override
    public boolean userExistsById(String id) {

        User user_to_find = userRepo.findById(id).orElse(null);
        return user_to_find!=null ? true : false;
    }

    @Override
    public Optional<List<User>> getAllUsers() {
        return Optional.of(userRepo.findAll());
    }
}
