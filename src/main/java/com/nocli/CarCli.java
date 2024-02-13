package com.nocli;

import com.nocli.annotations.Choice;
import com.nocli.booking.repositories.CarBookingDataAccessService;
import com.nocli.booking.services.CarBookingService;
import com.nocli.car.*;
import com.nocli.car.repositories.CarDataAccessService;
import com.nocli.car.services.CarService;
import com.nocli.user.repositories.UserDataAccessService;
import com.nocli.user.services.UserService;

import java.lang.reflect.Method;
import java.util.*;

public class CarCli {
    private final Scanner scanner;
    private final CarService carService;
    private final CarBookingService carBookingService;

    private final UserService userService;
    private final Class<?> choiceClass;
    private final Map<Integer, Runnable> choices;


    public CarCli(UserDataAccessService userDataService, CarBookingDataAccessService carBookingDataService, CarDataAccessService carDataService, Class<?> choiceClass) {
        this.scanner = new Scanner(System.in);
        this.carService = new CarService(carDataService);
        this.carBookingService = new CarBookingService(carBookingDataService, this.carService);
        this.userService = new UserService(userDataService);
        this.choiceClass = choiceClass;

        this.choices = new HashMap<>();
        this.getChoicesFromAnnotations();
    }

    private void getChoicesFromAnnotations() {
        List<Method> methods = Arrays.stream(choiceClass.getMethods()).filter(m -> m.isAnnotationPresent(Choice.class)).toList();

        methods.forEach(method -> {
            method.setAccessible(true);
            choices.put(method.getAnnotation(Choice.class).value(), () -> {
                try {
                    method.invoke(choiceClass.getConstructor().newInstance(), this);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            });
        });
    }

    public Map<Integer, Runnable> getChoices() {
        return choices;
    }

    public CarService getCarService() {
        return carService;
    }

    public CarBookingService getCarBookingService() {
        return carBookingService;
    }

    public UserService getUserService() { return userService; }

    public String input(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public int getResult(int firstOption, int lastOption) {
        int selection;
        System.out.print(": ");
        String text = scanner.nextLine();
        try {
            int result = Integer.parseInt(text);
            if (result < firstOption || result > lastOption) {
                System.out.println("❌ Invalid Option");
                selection = 0;
            } else selection = result;
        } catch (NumberFormatException e) {
            System.out.println("❌ Invalid Option");
            selection = 0;
        }
        return selection;
    }

    public boolean isValidUserId(String userId) {
        try {
            return userService
                    .getAllUsers()
                    .stream()
                    .anyMatch(user -> user.getUserId().equals(UUID.fromString(userId)));
        } catch (Exception e){
            return false;
        }
    }

    public boolean isAlreadyBooked(Car car) {
        return this.carBookingService
                .getCurrentBookings()
                .stream()
                .anyMatch(carBooking -> carBooking != null && carBooking.getCar() == car);
    }
}
