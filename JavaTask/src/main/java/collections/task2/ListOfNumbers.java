package collections.task2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListOfNumbers {
    public static void main(String[] args) {
        int y = 5;
        List<Integer> listToSort = new ArrayList<>();

        fillAList(listToSort, 10);
        System.out.println(listToSort+" - исходный список");
        for (int i=0; i<listToSort.size(); i++) {
            if (listToSort.get(i) > y) {
                for (int j = i+1; j<listToSort.size(); j++) {   //в оставшемся списке ищем элемент, который меньше y
                    if (listToSort.get(j) <= y) {
                        Collections.swap(listToSort, j, i);     //меняем местами элемент больше y и элемент мельше y
                    }
                }
            }
        }
        System.out.println(listToSort+" - сначала идут числа, не превосходящие Y, а затем числа, больше Y");
    }
    private static void fillAList(List<Integer> list, int numberOfElements) {
        for (int i=0; i<numberOfElements; i++) {
            list.add((int) (Math.random()*numberOfElements));
        }
    }

}
