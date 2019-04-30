package task1;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWithSortedNumbers {
    public static void main(String[] args) {
        InputOutput io = new InputOutput();
        io.setAmountOfNumbers(10);
        io.createNewDir();
        File file = io.createNewFile("txt", "task1");
        List<Integer> randomNumbers = io.generateRandomNumbers(io.getAmountOfNumbers());
        io.writeIntoTheFile(randomNumbers, file);
        System.out.println(randomNumbers);
        ArrayList<String> readNumbers = new ArrayList<>(io.readTheFileWithBreakingByWords(file));
        ArrayList<Integer> numbersToSort = new ArrayList<>();
        for (String str : readNumbers) {
            numbersToSort.add(Integer.parseInt(str));
        }
        Collections.sort(numbersToSort);
        io.writeIntoTheFile(numbersToSort, file);
    }
}
