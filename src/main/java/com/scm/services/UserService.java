package com.scm.services;

import com.scm.model.User;

import java.util.Optional;
import java.util.*;

public interface UserService {

    User saveUser(User user);
    Optional<User> getUserById(String id);
    void deleteUser(String id);
    Optional<User> updateUser(User user);
    boolean userExistsByEmail(String email);
    boolean userExistsById(String id);
    Optional<List<User>> getAllUsers();
}
