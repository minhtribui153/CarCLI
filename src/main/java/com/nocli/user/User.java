package com.nocli.user;

import jakarta.persistence.*;
import org.springframework.context.annotation.Primary;

import java.util.Objects;
import java.util.UUID;

public class User {

    private UUID userId;

    private String name;

    private String email;

    public User(UUID userId, String name, String email) {
        this.name = name;
        this.userId = userId;
        this.email = email;
    }

    public User(String name, UUID userId, String email) {
        this.name = name;
        this.userId = userId;
        this.email = email;
    }

    public User() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(getUserId(), user.getUserId()) && Objects.equals(getName(), user.getName()) && Objects.equals(getEmail(), user.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getName(), getEmail());
    }
}
