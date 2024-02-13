package com.nocli.booking.controllers;

import com.nocli.booking.CarBooking;
import com.nocli.booking.services.CarBookingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/bookings")
public class CarBookingController {
    private final CarBookingService carBookingService;

    public CarBookingController(CarBookingService carBookingService) {
        this.carBookingService = carBookingService;
    }

    @GetMapping
    public List<CarBooking> getAllCars() {
        return carBookingService.getCurrentBookings();
    }

    @GetMapping("{bookingId}")
    public CarBooking getCarByRegNumber(@PathVariable("bookingId") Integer bookingId) {
        return carBookingService.getBookingById(bookingId);
    }
}
