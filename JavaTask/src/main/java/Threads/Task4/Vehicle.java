package Threads.Task4;

import java.util.concurrent.TimeUnit;

import static Threads.Task4.Parking.PARKING_PLACES;
import static Threads.Task4.Parking.SEMAPHORE;

public class Vehicle extends Thread {
    private int id;

    Vehicle (int id) {
        this.id = id;
    }

    public void run() {
        System.out.println("Car №"+ id + " ask for parking place");
        boolean permit;
        try {
            // Если все места заняты, то автомобиль не станет ждать больше величины "timeout"
            permit = SEMAPHORE.tryAcquire(3, TimeUnit.SECONDS);
            if (permit) {

                // поиск свободного места и парковка на нём
                int parkingNumber = -1;
                for (int i = 0; i < PARKING_PLACES.length; i++) {
                    if (!PARKING_PLACES[i]) {
                        PARKING_PLACES[i] = true;
                        parkingNumber = i;
                        //добавим задержку, чтобы сообщение о получении места выводилось после освобождения места
                        sleep(100);
                        System.out.println("Car №"+id+" got parking place №"+i);
                        break;
                    }
                }

                // стоянка на 3 сек
                sleep(3000);

                // освобожаем место
                PARKING_PLACES[parkingNumber] = false;
                // открываем доступ
                SEMAPHORE.release();
                System.out.println("Car №"+id+" left parking place №"+parkingNumber);
            } else {
                // Если все места заняты, то автомобиль не станет ждать больше величины "timeout" и уедет на другую стоянку.
                System.out.println("Car №"+id+" went to another parking");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
