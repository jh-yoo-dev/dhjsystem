package com.dhjsystem.example.service;

import java.util.List;

import com.dhjsystem.example.domain.Role;
import com.dhjsystem.example.domain.User;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User> getUsers();
}
