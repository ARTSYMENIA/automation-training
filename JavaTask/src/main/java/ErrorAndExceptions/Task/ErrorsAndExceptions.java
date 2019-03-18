package ErrorAndExceptions.Task;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ErrorsAndExceptions {
    public static void main(String[] args) {
        BufferedReader buffReader = null;
        ArrayList<Integer> arrayWithNum = new ArrayList<>();
        int averagePrice = 0;
        try {
            buffReader = new BufferedReader(new FileReader("src/main/java/Java/ErrorAndExceptions/carInfo.txt"));
            String tmp = "";
            while ((tmp = buffReader.readLine()) != null) {
                String[] arrayWithRequiredCarInfo = tmp.split(", ");
                for (String elem : arrayWithRequiredCarInfo) {
                    try {
                        arrayWithNum.add(Integer.parseInt(elem));
                    } catch (NumberFormatException e) {
                        System.err.println(e);
                    }
                }
            }
            System.out.println(arrayWithNum);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (OutOfMemoryError error) {
            error.printStackTrace();
        } finally {
            if (buffReader != null) {
                try {
                    buffReader.close();
                } catch (IOException e) {
                    System.err.println("Close error"+e);
                }
            }
        }
        int countNumberOfCars = 0;
        int totalPrice = 0;
        for (int i=2; i < arrayWithNum.size(); i +=3) {
            totalPrice += arrayWithNum.get(i);
            countNumberOfCars++;
        }
        try {
            averagePrice = totalPrice/countNumberOfCars;
        } catch (ArithmeticException e) {
            System.err.println("Division by zero"+e);
        }
        try {
            System.out.println("First car prise: " + arrayWithNum.get(2));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Index 2 is out of array's bound"+e);
        }
        System.out.println("Average car price: "+averagePrice);
    }
}
