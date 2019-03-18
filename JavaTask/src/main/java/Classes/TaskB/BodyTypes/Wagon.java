package Classes.TaskB.BodyTypes;

import Classes.TaskB.Car;

public class Wagon extends Car {
    private int luggageCapacity;
    private int luggageAllowance;

    public Wagon(String registrationNumber, String brand, int fuelConsumption, int yearOfIssue, int speed, int price, int luggageCapacity, int luggageAllowance) {
        super(registrationNumber, brand, fuelConsumption, yearOfIssue, speed, price);
        this.luggageAllowance = luggageAllowance;
        this.luggageCapacity = luggageCapacity;
    }

    @Override
    public String toString() {
        return super.toString().replace("}",
                "luggageCapacity=" + luggageCapacity +
                        ", luggageAllowance=" + luggageAllowance +
                        '}');
    }
}
