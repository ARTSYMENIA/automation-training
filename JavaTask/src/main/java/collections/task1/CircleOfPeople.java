package collections.task1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CircleOfPeople {

    public static void main(String[] args) {
        int n = 10;
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            arrayList.add(i + 1);
            linkedList.add(i + 1);
        }
        System.out.println(arrayList + " исходный список номеров людей");
        System.out.println("результат рыботы для ArrayList");
        Long arrayListPerformingTime = getPerformingTime(arrayList);
        System.out.println("результат рыботы для LinkedList");
        Long linkedListPerformingTime = getPerformingTime(linkedList);
        if (arrayListPerformingTime - linkedListPerformingTime > 0) {
            System.out.println("LinkedList работает быстрее");
        } else {
            System.out.println("ArrayList работает быстрее");
        }
    }

    private static Long getPerformingTime(List list) {
        Long startTime = System.nanoTime();
        excludeEverySecondInCircle(list);
        Long endArrayList = System.nanoTime();
        System.out.println(list + " - номер последнего оставшегося человека");
        System.out.printf("%,d ns", endArrayList - startTime);
        System.out.println();
        return endArrayList - startTime;
    }

    private static void excludeEverySecondInCircle(List list) {
        int count = 0;
        Iterator iterator = list.iterator();
        while (list.size() > 1) {
            if (iterator.hasNext()) {
                iterator.next();
                count++;
                if (count == 2) {
                    iterator.remove();
                    count = 0;
                }
            } else {
                iterator = list.iterator();
                System.out.println(list);
            }
        }
    }
}