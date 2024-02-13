package com.nocli.booking.interfaces;

import com.nocli.booking.CarBooking;

import java.util.*;

public interface CarBookingDao {
    void addNewBooking(CarBooking carBooking);
    List<CarBooking> selectCurrentBookings();
    List<CarBooking> selectBookingsByUserId(UUID userId);
    Optional<CarBooking> selectBookingById(Integer bookingId);
}
