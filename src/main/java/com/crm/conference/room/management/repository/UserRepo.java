package com.crm.conference.room.management.repository;

import com.crm.conference.room.management.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
}
