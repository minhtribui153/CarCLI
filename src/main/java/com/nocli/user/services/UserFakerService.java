package com.nocli.user.services;

import com.nocli.user.User;
import net.datafaker.Faker;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;

public class UserFakerService {

    public static List<User> generateUsers(int number) {
        return IntStream.range(0, number)
                .mapToObj(i -> createUser()).toList();

    }

    public static User createUser() {
        Faker faker = new Faker();
        return new User(UUID.randomUUID(), faker.name().firstName(), faker.internet().emailAddress());
    }
}
