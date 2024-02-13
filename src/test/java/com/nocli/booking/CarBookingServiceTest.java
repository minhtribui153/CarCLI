package com.nocli.booking;

import com.nocli.booking.repositories.CarBookingDataAccessService;
import com.nocli.booking.services.CarBookingService;
import com.nocli.car.Car;
import com.nocli.car.repositories.CarDataAccessService;
import com.nocli.car.services.CarService;
import com.nocli.user.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CarBookingServiceTest {
    CarBookingDataAccessService carBookingDataAccessService = new CarBookingDataAccessService();
    CarDataAccessService carDataAccessService = new CarDataAccessService();
    CarService carService = new CarService(carDataAccessService);
    CarBookingService carBookingService = new CarBookingService(carBookingDataAccessService, carService);

    @Test
    @DisplayName("Can add a car booking")
    void canAddACarBooking() {
        Car car = carService.getAllCars().get(5);
        User user = new User(UUID.randomUUID(), "Leila");

        CarBooking carBooking = new CarBooking(1, car, user);

        carBookingService.addNewBooking(carBooking);

        boolean works = carBookingService
                .getCurrentBookings()
                .stream()
                .anyMatch(carBooking::equals);

        assertTrue(works);
    }
}
