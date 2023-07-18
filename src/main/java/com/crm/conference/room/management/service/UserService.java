package com.crm.conference.room.management.service;

import com.crm.conference.room.management.entity.User;
import com.crm.conference.room.management.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepo userRepository;

    public UserService(UserRepo userRepository) {
        this.userRepository = userRepository;
    }

    public void registerUser(String userId) {
        User user = new User();
        user.setUserId(userId);
        userRepository.save(user);
    }
}
