package com.nocli.booking.services;

import com.nocli.booking.CarBooking;
import com.nocli.booking.interfaces.CarBookingDao;
import com.nocli.car.services.CarService;
import com.nocli.exception.DuplicateResourceException;
import com.nocli.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CarBookingService {
    private final CarBookingDao carBookingDao;
    private final CarService carService;

    public CarBookingService(CarBookingDao carBookingDao, CarService carService) {
        this.carBookingDao = carBookingDao;
        this.carService = carService;
    }

    public void addNewBooking(CarBooking carBooking) {
        Objects.requireNonNull(carBooking, "CarBooking cannot be null");
        Objects.requireNonNull(carBooking.getId(), "Booking ID cannot be null");
        Objects.requireNonNull(carBooking.getCar(), "Car cannot be null");
        Objects.requireNonNull(carBooking.getUser(), "User cannot be null");

        boolean isCarPresent = carService.getAllCars().stream().anyMatch(car -> car.equals(carBooking.getCar()));
        if (!isCarPresent) throw new ResourceNotFoundException("Invalid Car");

        Optional<CarBooking> exists = carBookingDao.selectCurrentBookings()
                .stream()
                .filter(c -> c.getCar().equals(carBooking.getCar()))
                .findFirst();

        if (exists.isEmpty()) throw new DuplicateResourceException("Car already taken");

        carBookingDao.addNewBooking(carBooking);
    }

    public List<CarBooking> getBookingsByUserId(UUID userId) {
        return carBookingDao.selectBookingsByUserId(userId);
    }

    public CarBooking getBookingById(Integer bookingId) {
        return carBookingDao.selectBookingById(bookingId)
                .orElseThrow(() -> new ResourceNotFoundException("Car Booking with ID [%s] not found".formatted(bookingId)));
    }


    public List<CarBooking> getCurrentBookings() {
        return carBookingDao.selectCurrentBookings();
    }
}
