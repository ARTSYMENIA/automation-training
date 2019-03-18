package Threads.Task4;

import java.util.concurrent.Semaphore;

import static java.lang.Thread.sleep;

public class Parking {
    static final boolean[] PARKING_PLACES = new boolean[3];
    static final Semaphore SEMAPHORE = new Semaphore(3, true);
    private static final int numberOfCars = 6;
    public static void main(String[] args) throws InterruptedException {
        for (int i = 1; i <= numberOfCars; i++) {
            new Vehicle(i).start();
            sleep(100);
        }
    }
}


