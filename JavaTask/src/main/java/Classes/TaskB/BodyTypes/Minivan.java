package Classes.TaskB.BodyTypes;

import Classes.TaskB.Car;

public class Minivan extends Car {
    private int passengersCapacity;
    private int pricePerPerson;

    public Minivan(String registrationNumber, String brand, int fuelConsumption, int yearOfIssue, int speed, int price, int passengersCapacity, int pricePerPerson) {
        super(registrationNumber, brand, fuelConsumption, yearOfIssue, speed, price);
        this.passengersCapacity=passengersCapacity;
        this.pricePerPerson=pricePerPerson;
    }

    @Override
    public String toString() {
        return super.toString().replace("}",
                ", passengersCapacity=" + passengersCapacity +
                ", pricePerPerson=" + pricePerPerson +
                '}');
    }
}
