package Fundamentals.Task;

import java.util.Arrays;
import java.util.Scanner;

public class KeywordsTask {
    public static void main(String[] args) {

        //1.Приветствовать любого пользователя при вводе его имени через командную строку.
        Scanner consoleScanner = new Scanner(System.in);
        System.out.println("Enter username:");
        String nameScanner = consoleScanner.nextLine();
        System.out.println("Hello, dear "+nameScanner);
        consoleScanner.close();

        //2.Отобразить в окне консоли аргументы командной строки в обратном порядке.
        for (int i=args.length-1; i>=0; i--) {
            System.out.println("Arguments in reverse order: "+args[i]);
        }

        //3.Вывести заданное количество случайных чисел с переходом и без перехода на новую строку.
        int [] arrayWithRandomNumbers = new int [10];
        for (int i=0; i<arrayWithRandomNumbers.length; i++ ) {
            arrayWithRandomNumbers[i]= (int) (Math.random()*10);
        }
        System.out.println("Print in line "+ Arrays.toString(arrayWithRandomNumbers));
        for (int num : arrayWithRandomNumbers) {
            System.out.println("Print with switch to another line " + num);
        }
        //4.Ввести целые числа как аргументы командной строки, подсчитать их суммы и вывести результат на консоль.
        int sumOfArg = 0;
        for (String element : args) {
            sumOfArg = sumOfArg + Integer.parseInt(element);
        }
        System.out.println("sum of arguments= "+sumOfArg);
    }
}
