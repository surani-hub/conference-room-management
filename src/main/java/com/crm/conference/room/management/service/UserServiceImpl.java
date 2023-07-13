package com.crm.conference.room.management.service;

import com.crm.conference.room.management.entity.User;
import com.crm.conference.room.management.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;


    @Override
    public User register(User user) {
        int userId = user.getId();
        Optional<User> existing = userRepo.findById(userId);
        if(existing.get() != null){
            userRepo.save(user);
            return user;
        }
        return null;
    }
}
