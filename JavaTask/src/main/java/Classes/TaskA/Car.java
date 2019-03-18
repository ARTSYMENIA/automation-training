package Classes.TaskA;

import java.util.Objects;

public class Car {
    private int id;
    private String brand;
    private String model;
    private int yearOfIssue;
    private String color;
    private int price;
    private String registrationNumber;

    public Car(int id, String brand, String model, int yearOfIssue, String color, int price, String registrationNumber) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.yearOfIssue = yearOfIssue;
        this.color = color;
        this.price = price;
        this.registrationNumber = registrationNumber;
    }

    String getBrand() {
        return brand;
    }

    String getModel() {
        return model;
    }

    int getYearOfIssue() {
        return yearOfIssue;
    }

    int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "\nCar{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", yearOfIssue='" + yearOfIssue + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", registrationNumber='" + registrationNumber + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return  yearOfIssue == car.yearOfIssue &&
                price == car.price &&
                brand.equals(car.brand) &&
                model.equals(car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, yearOfIssue, price);
    }
}
