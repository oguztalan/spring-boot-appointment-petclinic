package com.oguztalan.petclinic.service;

import com.oguztalan.petclinic.entities.User;
import com.oguztalan.petclinic.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService  {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        if (user.getUserId() == null) {
            user = userRepository.save(user);

            return user;
        } else {
            return null;
        }

    }






}
