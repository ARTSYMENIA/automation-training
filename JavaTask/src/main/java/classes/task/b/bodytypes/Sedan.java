package classes.task.b.bodytypes;

import classes.task.b.ComfortLevels;
import classes.task.b.Car;

public class Sedan extends Car {
    private ComfortLevels comfortLevel;

    public Sedan(String registrationNumber, String brand, int fuelConsumption, int yearOfIssue, int speed, int price,  ComfortLevels comfortLevel) {
        super(registrationNumber, brand, fuelConsumption, yearOfIssue, speed, price);
        this.comfortLevel = comfortLevel;
    }

    @Override
    public String toString() {
        return super.toString().replace("}",
                ", comfortLevel=" + comfortLevel +
                        '}');
    }
}
