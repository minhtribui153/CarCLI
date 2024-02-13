package com.nocli.booking;

import com.nocli.car.Car;
import com.nocli.user.User;
import jakarta.persistence.*;

import java.util.Objects;

public class CarBooking {

    private Integer id;
    private Car car;
    private User user;

    public CarBooking(Integer id, Car car, User user) {
        this.id = id;
        this.car = car;
        this.user = user;
    }

    public Car getCar() {
        return car;
    }

    public User getUser() {
        return user;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "car=" + car +
                ", user=" + user +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarBooking booking = (CarBooking) o;
        return Objects.equals(getCar(), booking.getCar()) && Objects.equals(getUser(), booking.getUser());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCar(), getUser());
    }
}
