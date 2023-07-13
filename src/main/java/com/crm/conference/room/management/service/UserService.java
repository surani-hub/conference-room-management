package com.crm.conference.room.management.service;

import com.crm.conference.room.management.entity.User;
import org.springframework.http.ResponseEntity;

public interface UserService {
    public User register(User user);
}
