package Fundamentals.Task;
//  1. Упорядочить строки матрицы в порядке возрастания значений элементов k-го столбца.
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ArraysTask  {
    public static void main(String[] args) {
        Scanner consoleScanner = new Scanner(System.in);
        System.out.println("Enter matrix size n");
        int n = consoleScanner.nextInt();
        System.out.println("Enter column number k witch the matrix should be sorted by");
        int k = consoleScanner.nextInt();
        System.out.println("Enter a step to shift right");
        int stepToShift = consoleScanner.nextInt();
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = (int) ((Math.random() * (-2) * (n + 1)) + n + 1);
            }
        }
        System.out.println("Matrix before sort");
        outputMatrix(a);

        outputMatrix(arrangeRowsInAscendingOrderByColumn(a, k));

        outputMatrix(circularShiftLeft(a, stepToShift));

    }
    private static void outputMatrix(int[] [] matrixForOutput) {
        for (int i[] : matrixForOutput) {
            for (int j : i)
                System.out.print(String.format("%3d", j));
            System.out.println();
        }
    }
    private static int[] [] arrangeRowsInAscendingOrderByColumn(int[][] matrixForSort, int columnNumber) {
        Arrays.sort(matrixForSort, Comparator.comparingInt(x -> x[columnNumber]));
        System.out.println("Matrix after sort by column = "+(columnNumber));
        return matrixForSort;
    }
    private static int[][] circularShiftLeft(int[][] matrixForShift, int step) {
        int[][] temp = new int[matrixForShift.length] [matrixForShift.length];
        for (int i = 0; i<temp.length; i++) {
            for (int j = 0; j < temp.length; j++) {
                temp[i][j] = matrixForShift[i][(j + step) % temp.length];
            }
        }
        System.out.println("Matrix shifted by step = "+step);
        return temp;
    }
}
