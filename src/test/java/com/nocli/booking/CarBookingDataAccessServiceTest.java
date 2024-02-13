package com.nocli.booking;

import com.nocli.booking.repositories.CarBookingDataAccessService;
import com.nocli.car.Car;
import com.nocli.user.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.UUID;

public class CarBookingDataAccessServiceTest {
    CarBookingDataAccessService carBookingService = new CarBookingDataAccessService();
    Car car = new Car("Testing Car Model", new BigDecimal("750.00"), "SBT2358M", false);
    User user = new User("Testing User", UUID.randomUUID(), "testingusr@gmail.com");

    @Test
    @DisplayName("Can add a car booking")
    void canAddACarBooking() {

        CarBooking carBooking = new CarBooking(1, car, user);

        carBookingService.addNewBooking(carBooking);

        boolean works = carBookingService
                .selectCurrentBookings()
                .stream()
                .anyMatch(carBooking::equals);

        assertTrue(works);
    }

    @Test
    @DisplayName("Cannot add null CarBooking")
    void cannotAddNullCarBooking() {
        Exception e = assertThrows(NullPointerException.class, () -> carBookingService.addNewBooking(null));
        assertEquals("CarBooking cannot be null", e.getMessage());
    }

    @Test
    @DisplayName("Cannot add null Car to CarBooking")
    void cannotAddNullCarToCarBooking() {
        CarBooking carBooking = new CarBooking(1, null, user);
        Exception e = assertThrows(NullPointerException.class, () -> carBookingService.addNewBooking(carBooking));
        assertEquals("Car cannot be null", e.getMessage());
    }

    @Test
    @DisplayName("Cannot add null User to CarBooking")
    void cannotAddNulUserToCarBooking() {
        CarBooking carBooking = new CarBooking(1, car, null);
        Exception e = assertThrows(NullPointerException.class, () -> carBookingService.addNewBooking(carBooking));
        assertEquals("User cannot be null", e.getMessage());
    }
}
