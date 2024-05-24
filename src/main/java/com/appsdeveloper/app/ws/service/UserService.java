package com.appsdeveloper.app.ws.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.appsdeveloper.app.ws.shared.dto.UserDto;

public interface UserService extends UserDetailsService {
    UserDto createdUser(UserDto user);
    UserDto getUser(String email);
    UserDto getUserByUSerId(String Id);
    UserDto updateUser(String userId, UserDto user);
}
