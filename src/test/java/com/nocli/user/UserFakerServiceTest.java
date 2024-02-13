package com.nocli.user;

import com.nocli.user.services.UserFakerService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserFakerServiceTest {
    final int amount = 20;

    @Test
    @DisplayName("Can generate users by correct amount")
    void canGenerateUsersByCorrectAmount() {
        assertEquals(amount, UserFakerService.generateUsers(amount).size());
    }
}
