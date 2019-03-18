package ErrorAndExceptions.Task;

// This task is performed with creating an exceptional situation using an example from Java.Classes.TaskA

import Classes.TaskA.Car;
import Classes.TaskA.CarArray;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ErrorAndExceptions {
    private static ArrayList<String> carsInfo = new ArrayList<>();
    private static List<Car> cars = new ArrayList<>();

    public static void main(String[] args) {
        BufferedReader buffReader = null;
        try {
            buffReader = new BufferedReader(new FileReader("src/main/java/Java/ErrorAndExceptions/carInfo.txt"));
            String tmp = "";
            try {
                while ((tmp = buffReader.readLine()) != null) {
                    String[] arrayWithRequiredCarInfo = tmp.split(", ");
                    for (String sample : arrayWithRequiredCarInfo) {
                        carsInfo.add(sample);
                    }
                }
            } catch (OutOfMemoryError error) {
                error.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            System.err.println("Required file not found"+e);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String requiredBrand = "Bentley";
        int exploitationTime = 2;
        String requiredModel = "C5";
        int yearOfIssue = 2018;
        int price = 25000;
        int numberOfCarParams = 7;
        int numberOfCars = 0;

        try {
            numberOfCars = carsInfo.size()/numberOfCarParams;
        }catch (ArithmeticException e) {
            System.err.println("Division by zero"+e);
        }
        int i = 0;
        for (int j=0; j < numberOfCars; j++) {
            try {
                cars.add(new Car(Integer.parseInt(carsInfo.get(i)), carsInfo.get(i+1), carsInfo.get(i+2), Integer.parseInt(carsInfo.get(i+3)),
                        carsInfo.get(i+4), Integer.parseInt(carsInfo.get(i+5)), carsInfo.get(i+6)));
            } catch (IllegalArgumentException e) {
                System.err.println("Illegal argument for class Car constructor"+e);
            }
            i+=numberOfCarParams;
        }

        CarArray carArray = new CarArray(cars);
        System.out.println(carArray.toString());
        System.out.println("\nList of cars of the "+requiredBrand+" brand: "+carArray.getCarsRequiredBrand(requiredBrand));
        System.out.println("\nList of cars of the model: "+requiredModel+", which were exploited for "+exploitationTime
                +" year(s)"+carArray.getCarsRequiredModelAndExploitationTimeMoreThenRequired(requiredModel, exploitationTime));
        System.out.println("\nList of cars issued in "+yearOfIssue+", which price is more then "+price
                +"\t"+carArray.getCarsRequiredYearOfIssueAndMoreThenRequiredPrice(yearOfIssue, price));
    }
}
