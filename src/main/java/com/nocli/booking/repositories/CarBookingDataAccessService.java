package com.nocli.booking.repositories;

import com.nocli.booking.CarBooking;
import com.nocli.booking.interfaces.CarBookingDao;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class CarBookingDataAccessService implements CarBookingDao {
    private List<CarBooking> carBookings;

    public CarBookingDataAccessService() {
        this.carBookings = new ArrayList<>();
    }


    @Override
    public void addNewBooking(CarBooking carBooking) {
        carBookings.add(carBooking);
    }

    @Override
    public List<CarBooking> selectCurrentBookings() {
        return carBookings;
    }

    @Override
    public List<CarBooking> selectBookingsByUserId(UUID userId) {
        return selectCurrentBookings().stream()
                .filter(c -> c.getUser().getUserId().equals(userId))
                .toList();
    }

    @Override
    public Optional<CarBooking> selectBookingById(Integer bookingId) {
        return selectCurrentBookings().stream()
                .filter(c -> c.getId().equals(bookingId))
                .findFirst();
    }
}
