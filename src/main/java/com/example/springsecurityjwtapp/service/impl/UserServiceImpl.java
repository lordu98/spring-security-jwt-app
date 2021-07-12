package com.example.springsecurityjwtapp.service.impl;

import com.example.springsecurityjwtapp.entity.Role;
import com.example.springsecurityjwtapp.entity.Status;
import com.example.springsecurityjwtapp.entity.User;
import com.example.springsecurityjwtapp.repo.RoleRepository;
import com.example.springsecurityjwtapp.repo.UserRepository;
import com.example.springsecurityjwtapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private BCryptPasswordEncoder passwordEncoder;

    private UserRepository userRepository;
    private RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public User register(User user) {
        Role roleUser = roleRepository.findByName("ROLE_USER");
        List<Role> userRoles = new ArrayList<>();
        userRoles.add(roleUser);

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(userRoles);
        user.setStatus(Status.ACTIVE);

        User save = userRepository.save(user);
        return save;
    }

    @Override
    public List<User> getAll() {
        List<User> result = userRepository.findAll();
        return result;
    }

    @Override
    public User findByUsername(String username) {
        User byUsername = userRepository.findByUsername(username);
        return byUsername;
    }

    @Override
    public User findById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        return user;
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
