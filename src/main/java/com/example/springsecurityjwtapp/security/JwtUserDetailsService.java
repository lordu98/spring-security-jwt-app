package com.example.springsecurityjwtapp.security;

import com.example.springsecurityjwtapp.entity.User;
import com.example.springsecurityjwtapp.security.jwt.JwtUser;
import com.example.springsecurityjwtapp.security.jwt.JwtUserFactory;
import com.example.springsecurityjwtapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    private final UserService userService;

    @Autowired
    public JwtUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userService.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User with username : " + username + "not found");
        }

        JwtUser jwtUser= JwtUserFactory.create(user);


        return jwtUser;
    }
}
