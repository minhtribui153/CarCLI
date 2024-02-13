package com.nocli;

import com.nocli.annotations.*;
import com.nocli.booking.*;
import com.nocli.booking.repositories.CarBookingDataAccessService;
import com.nocli.car.*;
import com.nocli.car.repositories.CarDataAccessService;
import com.nocli.user.*;
import com.nocli.user.repositories.UserDataAccessService;

import java.util.*;

import static com.nocli.utils.Utils.printList;

public class Cli {
    static UserDataAccessService userDataService = new UserDataAccessService();
    static CarBookingDataAccessService carBookingDataService = new CarBookingDataAccessService();
    static CarDataAccessService carDataService = new CarDataAccessService();

    static Integer countId = 1;
    public static void main(String[] args) {
        CarCli carCli = new CarCli(userDataService, carBookingDataService, carDataService, Cli.class);

        boolean running = true;

        int selectionNumber = 0;

        while(running) {
            System.out.println("===========================================");
            switch (selectionNumber) {
                case 0 -> {
                    showMenu();
                    selectionNumber = carCli.getResult(1, 7);
                }
                case 7 -> running = false;
                default -> {
                    Runnable method = carCli.getChoices().get(selectionNumber);
                    if (!Objects.isNull(method)) method.run();
                    selectionNumber = 0;
                }
            }
        }
    }

    public static void showMenu() {
        System.out.println("""
                1️⃣  - Book Car
                2️⃣  - View All User Booked Cars
                3️⃣  - View All Bookings
                4️⃣  - View Available Cars
                5️⃣  - View Available Electric Cars
                6️⃣  - View all users
                7️⃣  - Exit
                """);
    }

    @Choice(1)
    public void bookCar(CarCli carCli) {
        var userId = carCli.input("➡️ Enter User ID: ");
        if (carCli.isValidUserId(userId)) {
            var regNumber = carCli.input("➡️ Enter car registration number: ");

            Car chosenCar = carCli.getCarService().getCarByRegNumber(regNumber);

            if (Objects.isNull(chosenCar)) System.out.println("❌ Invalid Registration number");
            else {
                if (carCli.isAlreadyBooked(chosenCar))
                    System.out.println("❌ " + chosenCar.getName() + " | " + regNumber + " has already been booked");
                else {
                    CarBooking carBooking = new CarBooking(countId++, chosenCar, carCli.getUserService().getUserById(UUID.fromString(userId)));
                    carCli.getCarBookingService().addNewBooking(carBooking);
                    System.out.println("✅ You have successfully booked a " + chosenCar.getName() + " | " + regNumber);
                }
            }
        } else System.out.println("❌ Invalid ID");
    }

    @Choice(2)
    public void viewAllUserBookedCars(CarCli carCli) {
        var userId = carCli.input("➡️ Enter User ID: ");
        if (carCli.isValidUserId(userId)) {
            User user = carCli.getUserService().getUserById(UUID.fromString(userId));
            List<CarBooking> carBookings = carCli.getCarBookingService().getBookingsByUserId(UUID.fromString(userId));

            if (carBookings.isEmpty()) System.out.println("❌ No bookings were made by " + user.getName() + " yet");
            else {
                System.out.println("ℹ️ Here are the current bookings by " + user.getName() + ":");
                printList(carBookings);
            }
        } else {
            System.out.println("❌ Invalid ID");
        }
    }

    @Choice(3)
    public void viewAllBookings(CarCli carCli) {
        if (carCli.getCarBookingService().getCurrentBookings().isEmpty()) System.out.println("❌ No current car bookings were made ☹️");
        else printList(carCli.getCarBookingService().getCurrentBookings());
    }

    @Choice(4)
    public void viewAvailableCars(CarCli carCli) {
        List<Car> carList = carCli.getCarService().getAllNormalCars().stream().filter(car -> !carCli.isAlreadyBooked(car)).toList();
        if (carList.isEmpty()) System.out.println("❌ No cars available ☹️");
        else {
            System.out.println("ℹ️ Here are the available cars:");
            printList(carList);
        }
    }

    @Choice(5)
    public void viewAvailableElectricCars(CarCli carCli) {
        List<Car> electricCarList = carCli.getCarService().getAllElectricCars().stream().filter(car -> !carCli.isAlreadyBooked(car)).toList();

        if (electricCarList.isEmpty()) System.out.println("❌ No electric cars available ☹️");
        else {
            System.out.println("ℹ️ Here are the available electric cars:");
            printList(electricCarList);
        }
    }

    @Choice(6)
    public void viewAllUsers(CarCli carCli) {
        System.out.println("ℹ️ Here are the registered users:");
        printList(carCli.getUserService().getAllUsers());
    }
}
