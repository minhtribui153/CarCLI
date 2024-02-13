package com.nocli.user.services;

import com.nocli.exception.ResourceNotFoundException;
import com.nocli.utils.FileUtils;
import com.nocli.user.User;
import com.nocli.user.interfaces.UserDao;
import org.springframework.stereotype.Service;

import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    private UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
        this.registerUsersFromCSV();
    }

    public void registerUsersFromCSV() {
        Optional.ofNullable(getClass().getClassLoader().getResource("users.csv"))
                .map(URL::getPath)
                .map(File::new)
                .filter(File::exists)
                .map(FileUtils::readFile)
                .ifPresent(data -> Arrays.stream(data)
                        .map(d -> d.split(","))
                        .skip(1)
                        .map(userData -> new User(UUID.fromString(userData[0]), userData[1], userData[2]))
                        .forEach(this::registerUser));
    }

    public List<User> getAllUsers() {
        return userDao.selectAllUsers();
    }

    public void registerUser(User user) {
        userDao.addUser(user);
    }

    public User getUserById(UUID uuid) {
        return userDao.selectUserById(uuid)
                .orElseThrow(() -> new ResourceNotFoundException("User with ID [%s] not found".formatted(uuid)));
    }
}
