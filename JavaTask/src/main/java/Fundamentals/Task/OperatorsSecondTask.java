package Fundamentals.Task;
//2.Ввести число от 1 до 12. Вывести на консоль название месяца, соответствующего данному числу.
//  Осуществить проверку корректности ввода чисел.

import java.util.Scanner;

public class OperatorsSecondTask {
    public static void main(String[] args) {
        Scanner consoleScanner = new Scanner(System.in);
        System.out.println("Enter a number from 1 to 12");
        int numberOfMonth = consoleScanner.nextInt();
        String [] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        if (numberOfMonth<1 || numberOfMonth>12) {
            throw new IllegalArgumentException("Incorrect value");
        }
        for (int i = 1; i <=12; i++) {
            if (numberOfMonth == i) {
                System.out.println(months[i]);
            }
        }
    }
}
