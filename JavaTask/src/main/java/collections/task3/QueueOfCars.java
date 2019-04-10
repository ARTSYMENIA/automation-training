package collections.task3;

import java.util.List;
import java.util.Queue;

class QueueOfCars {
    private Queue carsList;

    QueueOfCars(Queue carsList) {
        this.carsList = carsList;
    }

    Queue getCarsList() {
        return carsList;
    }

    void parkACar(String brand, List<String> parkingSpaces) {
        if (parkingSpaces.contains(null)) {
            int i =0;
            while (i < parkingSpaces.size()) {
                if (parkingSpaces.get(i) == null) {
                    parkingSpaces.set(i, brand);
                    System.out.println(brand+" parked at the space #"+ i);
                    break;
                }   else {
                    i++;
                }
            }
        }   else {
            System.out.println("Нет парковочных мест для"+brand);
        }
    }
}
