package com.nocli.user;

import com.nocli.user.repositories.UserDataAccessService;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class UserDataAccessServiceTest {
    UserDataAccessService userService = new UserDataAccessService();
    Random random = new Random();
    UUID uuid = UUID.fromString("7e4b9220-a47a-45a7-a33b-7182ee0dc30e");
    User user = new User(uuid, "Leila", "leila@gmail.com");

    @Test
    @DisplayName("Can register users from CSV File")
    void canRegisterUsersFromCSVFile() {
        assertEquals(0, userService.selectAllUsers().size());
        userService.selectAllUsers().forEach(System.out::println);
    }

    @RepeatedTest(value = 10, name = "Iteration {currentRepetition} of {totalRepetitions}")
    @Disabled("Disabled until users can be added")
    @DisplayName("Can find user by ID")
    void canFindUserByID() {
        List<User> users = userService.selectAllUsers();
        users.add(user);
        User user = users.get(random.nextInt(users.size() - 1));
        assertEquals(user, userService.getUserById(user.getUserId()));
        System.out.println(userService.getUserById(user.getUserId()));
    }
}
