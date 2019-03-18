package Classes.TaskA;

import java.util.Arrays;
import java.util.List;

public class Runner {
    private static List<Car> cars = Arrays.asList(
            new Car(1, "Alfa Romeo", "Giulia", 2015, "Red", 15000, "1212 IM-7"),
            new Car(2, "Bentley", "FlyingSpur", 2016, "Grey", 95000, "0001 II-7"),
            new Car(3, "Bentley", "Continental", 2011, "Silver", 45000, "0011 II-7"),
            new Car(4, "Citroen", "C5", 2014, "Black", 12000, "1224 IO-7"),
            new Car(5, "Citroen", "C5", 2018, "Black", 20000, "6424 IO-7"),
            new Car(6, "Dodge", "Challenger", 2018, "Yellow", 40000, "7777 XX-7")
            );

    public static void main(String[] args) {
        String requiredBrand = "Bentley";
        int exploitationTime = 2;
        String requiredModel = "C5";
        int yearOfIssue = 2018;
        int price = 25000;
        CarArray carArray = new CarArray(cars);
        System.out.println(carArray.toString());
        System.out.println("\nList of cars of the "+requiredBrand+" brand: "+carArray.getCarsRequiredBrand(requiredBrand));
        System.out.println("\nList of cars of the model: "+requiredModel+", which were exploited for "+exploitationTime+" year(s)"+carArray.getCarsRequiredModelAndExploitationTimeMoreThenRequired(requiredModel, exploitationTime));
        System.out.println("\nList of cars issued in "+yearOfIssue+", which price is more then "+price+"\t"+carArray.getCarsRequiredYearOfIssueAndMoreThenRequiredPrice(yearOfIssue, price));
    }
}
