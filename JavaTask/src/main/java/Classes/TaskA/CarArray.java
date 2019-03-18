package Classes.TaskA;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CarArray {
    private List<Car> cars;

    public CarArray(List<Car> cars) {
        this.cars = cars;
    }
    public List<Car> getCarsRequiredBrand(String brandName) {
        List<Car> requiredBrandFromCarList = new ArrayList<>();
        for (Car car : cars) {
            if (brandName.equals(car.getBrand())) {
                requiredBrandFromCarList.add(car);
            }
        }
        return requiredBrandFromCarList;
    }
    public List<Car> getCarsRequiredModelAndExploitationTimeMoreThenRequired(String modelName, int exploitationTime) {
        List<Car> requireModelFromCarList = new ArrayList<>();
        for (Car car : cars) {
            if (modelName.equals(car.getModel()) && (Calendar.getInstance().get(Calendar.YEAR) - car.getYearOfIssue()) > exploitationTime) {
                requireModelFromCarList.add(car);
            }
        }
        return requireModelFromCarList;
    }

    public List<Car> getCarsRequiredYearOfIssueAndMoreThenRequiredPrice(int yearOfIssue, int price) {
        List<Car> carsWithRequiredYearOfIssue = new ArrayList<>();
        for (Car car : cars) {
            if (yearOfIssue == car.getYearOfIssue() && car.getPrice() > price) {
                carsWithRequiredYearOfIssue.add((car));
            }
        }
        return carsWithRequiredYearOfIssue;
    }

    @Override
    public String toString() {
        return "CarArray{" +
                "cars=" + cars +
                '}';
    }
}

