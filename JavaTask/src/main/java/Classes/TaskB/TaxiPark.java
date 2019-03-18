package Classes.TaskB;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TaxiPark {
    private List<? extends Car> cars;

    TaxiPark(List<? extends Car> cars) {
        this.cars = cars;
    }

    List<? extends Car> getCars() {
        return cars;
    }

    int getTaxiParkPrice() {
        int taxiParkPrice = 0;
        for (Car sample: cars) {
            taxiParkPrice +=sample.getPrice();
        }
        return taxiParkPrice;
    }
    TaxiPark sortByFuelConsumption() {
        cars.sort(Comparator.comparing(Car :: getFuelConsumption));
        return this;
    }
    List<Car> getCarsWithRequiredSpeedRange(int lowerLimit, int upperLimit) {
        List<Car> carsWithRequiredSpeedRange = new ArrayList<>();
        for (Car sample : cars) {
            if (lowerLimit < sample.getSpeed() &&  sample.getSpeed() < upperLimit) {
                carsWithRequiredSpeedRange.add(sample);
            }
        }
        return carsWithRequiredSpeedRange;
    }

    @Override
    public String toString() {
        return "TaxiPark{" +
                cars.toString() +
                '}';
    }
}
