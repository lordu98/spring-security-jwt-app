package com.example.springsecurityjwtapp.repo;

import com.example.springsecurityjwtapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    User findByUsername(String name);

}
