package collections.task3;

import java.util.*;

public class Traffic {
    public static void main(String[] args) {
        Queue<String> cars = new LinkedList<>();
        cars.add("Aston");
        cars.add("Alfa");
        cars.add("Bentley");
        cars.add("BMW");
        cars.add("Mazda");
        cars.add("Mercedes");
        cars.add("Renault");
        cars.add("Citroen");
        cars.add("Ford");
        cars.add("Dacia");
        cars.add("Lambo");

        Parking parking = new Parking();
        parking.setNumberOfParkingSpaces(10);
        List<String> listOfParkingSpaces = parking.createNSpacesParking(parking.getNumberOfParkingSpaces());

        QueueOfCars queueOfCars = new QueueOfCars(cars);

        System.out.println(listOfParkingSpaces);
        System.out.println(queueOfCars.getCarsList());

        String car;
        while ((car = (String) queueOfCars.getCarsList().poll()) != null) {
            queueOfCars.parkACar(car, listOfParkingSpaces);
        }
        System.out.println(listOfParkingSpaces);
        System.out.println(queueOfCars.getCarsList()+" - queue of cars");

        for (int i = 0; i < listOfParkingSpaces.size(); i++) {
            if (listOfParkingSpaces.get(i) != null) {
                parking.leaveAParking(listOfParkingSpaces);
            }
        }
        System.out.println(listOfParkingSpaces);
    }
}
