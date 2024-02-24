package com.clone.bookmyshow.services;

import com.clone.bookmyshow.models.User;
import com.clone.bookmyshow.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserRepository userRepository;

    public User signUp(String email, String password){
        // Check if the user is already exists
        Optional<User> userOptional = userRepository.findByEmail(email);
        if(userOptional.isPresent())
            throw new RuntimeException("user with this email is already exists");

        // Create a new user object and persists in Db
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setBooking(new ArrayList<>());
        return userRepository.save(user);

        // Password encryption
        // user.setPassword(bCryptPasswordEncoder.encode(password));
        // if(bCryptPasswordEncoder.matches(password, user.getPassword()))
    }
}