package com.nocli.user.repositories;

import com.nocli.user.User;
import com.nocli.user.interfaces.UserDao;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserDataAccessService implements UserDao {
    private List<User> users;

    public UserDataAccessService() {
        this.users = new ArrayList<>();
    }

    @Override
    public List<User> selectAllUsers() { return users; }

    @Override
    public Optional<User> selectUserById(UUID uuid) {
        return users.stream()
                .filter(u -> u.getUserId().equals(uuid))
                .findFirst();
    }

    @Override
    public void addUser(User user) { users.add(user); }
}
