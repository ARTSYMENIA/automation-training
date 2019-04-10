package collections.task3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

class Parking {
    private int numberOfParkingSpaces;

    void setNumberOfParkingSpaces(int numberOfParkingSpaces) {
        this.numberOfParkingSpaces = numberOfParkingSpaces;
    }

    int getNumberOfParkingSpaces() {
        return numberOfParkingSpaces;
    }

    List<String> createNSpacesParking(int n) {
        return Arrays.asList(new String[n]);
    }

    void leaveAParking(List<String> parkingSpaces) {
        List<Integer> indexesOfParkedCars = new LinkedList<>();
        for (int i = 0; i < parkingSpaces.size(); i++) {
            if ((parkingSpaces.get(i) != null)) {
                indexesOfParkedCars.add(i);
            }
        }
        Random rand = new Random();
        int index = rand.nextInt(indexesOfParkedCars.size());
        int randomIndexOfParkedCar = indexesOfParkedCars.get(index);
        System.out.println(parkingSpaces.get(randomIndexOfParkedCar)+" left parking");
        parkingSpaces.set(randomIndexOfParkedCar, null);
    }
}
