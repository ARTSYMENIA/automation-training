package Classes.TaskB;

import Classes.TaskB.BodyTypes.Minivan;
import Classes.TaskB.BodyTypes.Sedan;
import Classes.TaskB.BodyTypes.Wagon;

import java.util.Arrays;
import java.util.List;

public class Runner {
    private static List<Car> cars = Arrays.asList(
            new Sedan("1122 AA-1", "Renault", 5, 2017, 175, 15000, ComfortLevels.ECONOM),
            new Sedan("2233 BB-2", "BMW", 14, 2015, 250, 29000, ComfortLevels.BUSINESS),
            new Minivan("5115 OP-6", "Mercedes", 12, 2017, 210, 24000, 7, 3),
            new Wagon("7689 MP-7", "AUDI", 10, 2012, 220, 14000, 720, 5)
            );

    public static void main(String[] args) {
        int upperSpeedLimit = 215;
        int lowerSpeedLimit = 180;
        TaxiPark taxiPark = new TaxiPark(cars);
        System.out.println("Taxi park includes next cars: "+taxiPark.getCars());
        System.out.println("Total taxi park price = "+taxiPark.getTaxiParkPrice());
        System.out.println("Taxi park sorted by fuelConsumption\n"+taxiPark.sortByFuelConsumption().toString());
        System.out.println("List of cars, which speed is between "+lowerSpeedLimit+" and "+upperSpeedLimit
                +taxiPark.getCarsWithRequiredSpeedRange(lowerSpeedLimit,upperSpeedLimit));
    }
}
