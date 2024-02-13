package com.nocli.user.interfaces;

import com.nocli.user.User;

import java.util.*;
public interface UserDao {
    List<User> selectAllUsers();
    Optional<User> selectUserById(UUID uuid);
    void addUser(User user);
    default User getUserById(UUID id) {
        List<User> matchingUsers = selectAllUsers().stream().filter(u -> u.getUserId().equals(id)).toList();
        return matchingUsers.size() > 0 ? matchingUsers.get(0) : null;
    }
}

