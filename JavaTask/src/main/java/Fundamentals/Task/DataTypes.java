package Fundamentals.Task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class DataTypes {
    public static void main(String[] args) {
        //Ввести n чисел с консоли.
        Scanner consoleScanner = new Scanner(System.in);
        System.out.println("Enter numbers");
        String enteredNumbers = consoleScanner.nextLine();
        String[] splitedArrayWithNumbers = enteredNumbers.split(" ");
        ArrayList<Integer> enteredNumbersArray = new ArrayList<Integer>();

        ArrayList<String> shortestNumbers = new ArrayList<String>();
        ArrayList<String> longestNumbers = new ArrayList<String>();
        shortestNumbers.add(splitedArrayWithNumbers[0]);
        longestNumbers.add(splitedArrayWithNumbers[0]);

        for (String sample : splitedArrayWithNumbers) {
            enteredNumbersArray.add(Integer.parseInt(sample));

            //1.Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.
            if (sample.length() < shortestNumbers.get(0).length()) {
                shortestNumbers.set(0, sample);
            } else if (sample.length() == shortestNumbers.get(0).length() && !sample.equals(shortestNumbers.get(0))) {
                shortestNumbers.add(sample);
            }
            if (sample.length() > longestNumbers.get(0).length()) {
                longestNumbers.set(0, sample);
            } else if (sample.length() == longestNumbers.get(0).length() && !sample.equals(longestNumbers.get(0))) {
                longestNumbers.add(sample);
            }
        }
        //  2.Упорядочить и вывести числа в порядке возрастания (убывания) значений их длины.
            Comparator<String> stringLengthComparator = new StringLengthSort();

            Arrays.sort(splitedArrayWithNumbers, stringLengthComparator); // применяем сортировку
            for(String str : splitedArrayWithNumbers){
            System.out.println(str);
            }

        System.out.println(enteredNumbersArray);
        System.out.println("Shortest numbers: " + shortestNumbers + "\nlength of the shortest numbers = " + shortestNumbers.get(0).length());
        System.out.println("Longest numbers: " + longestNumbers + "\nlength of the longest numbers = " + longestNumbers.get(0).length());
    }
}
class StringLengthSort implements Comparator<String>{
    @Override
    public int compare(String o1, String o2) {
        if(o1.length() > o2.length()){
            return 1;
        }else{
            if(o1.length() < o2.length()){
                return -1;
            }else{
                return 0;
            }
        }
    }
}

