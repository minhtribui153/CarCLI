package com.nocli.car;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;

public class Car {

    private String regNumber;

    private String name;

    private BigDecimal rentalPricePerDay;

    private boolean isElectric;

    public Car(String name, BigDecimal rentalPricePerDay, String regNumber, boolean isElectric) {
        this.name = name;
        this.rentalPricePerDay = rentalPricePerDay;
        this.regNumber = regNumber;
        this.isElectric = isElectric;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getRentalPricePerDay() {
        return rentalPricePerDay;
    }

    public void setRentalPricePerDay(BigDecimal rentalPricePerDay) {
        this.rentalPricePerDay = rentalPricePerDay;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public boolean isElectric() {
        return isElectric;
    }

    public void setElectric(boolean electric) {
        isElectric = electric;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", regNumber='" + regNumber + '\'' +
                ", rentalPricePerDay=" + rentalPricePerDay +
                ", isElectric=" + isElectric +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(getName(), car.getName()) && Objects.equals(getRegNumber(), car.getRegNumber()) && Objects.equals(getRentalPricePerDay(), car.getRentalPricePerDay());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getRegNumber(), getRentalPricePerDay());
    }
}
