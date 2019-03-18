package Classes.TaskB;

import java.util.Objects;

public class Car {
    private String registrationNumber;
    private String brand;
    private int fuelConsumption;
    private int yearOfIssue;
    private int speed;
    private int price;

    public Car(String registrationNumber, String brand, int fuelConsumption, int yearOfIssue, int speed, int price) {
        this.registrationNumber = registrationNumber;
        this.brand = brand;
        this.fuelConsumption = fuelConsumption;
        this.yearOfIssue = yearOfIssue;
        this.speed = speed;
        this.price = price;
    }

    int getFuelConsumption() {
        return fuelConsumption;
    }

    int getSpeed() {
        return speed;
    }

    int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return  "\nregistrationNumber='" + registrationNumber + '\'' +
                ", brand='" + brand + '\'' +
                ", fuelConsumption=" + fuelConsumption +
                ", yearOfIssue=" + yearOfIssue +
                ", speed='" + speed + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return fuelConsumption == car.fuelConsumption &&
                speed == car.speed;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fuelConsumption, speed);
    }
}
