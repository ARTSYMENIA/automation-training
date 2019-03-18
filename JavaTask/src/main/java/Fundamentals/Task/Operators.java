package Fundamentals.Task;
//  1.Определить принадлежность некоторого значения k интервалам (n, m], [n, m), (n, m), [n, m].

import java.util.ArrayList;
import java.util.Scanner;

public class Operators {
    public static void main(String[] args) {
        Scanner consoleScanner = new Scanner(System.in);
        System.out.println("Enter a value k");
        int k = consoleScanner.nextInt();
        System.out.println("Enter a value n");
        int n = consoleScanner.nextInt();
        System.out.println("Enter a value m");
        int m = consoleScanner.nextInt();

        String firstInterval = "value is in the interval (n, m]";
        String secondInterval = "value is in the interval [n, m)";
        String thirdInterval = "value is in the interval (n, m)";
        String fourthInterval = "value is in the interval [n, m]";

        ArrayList<String> hittedIntervals = new ArrayList<String>();
        if ((k > n && k <= m)) {hittedIntervals.add(firstInterval);}
        if ((k >= n && k < m)) {hittedIntervals.add(secondInterval);}
        if ((k > n && k < m)) {hittedIntervals.add(thirdInterval);}
        if ((k >= n && k <= m)) {hittedIntervals.add(fourthInterval);}
        System.out.println(hittedIntervals);
    }
}
