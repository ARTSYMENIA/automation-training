package task1;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class InputOutput {

	private int amountOfNumbers;

	public void setAmountOfNumbers(int amountOfNumbers) {
		this.amountOfNumbers = amountOfNumbers;
	}

	public int getAmountOfNumbers() {
		return amountOfNumbers;
	}

	public void createNewDir() {
		File dir = new File("data");
		dir.mkdir();
	}

	public File createNewFile (String fileExtension, String fileName) {
		return new File("data"+File.separator+fileName+"."+fileExtension);
	}

	public List<String> readTheFileWithBreakingByWords(File file) {
		List<String> singleWords = null;
		try (FileReader reader = new FileReader(file);
			 BufferedReader bufferedReader = new BufferedReader(reader)) {
			String line = null;
			singleWords = new ArrayList<>();
			while ((line = bufferedReader.readLine()) != null) {
				Collections.addAll(singleWords, line.split("\\s"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return singleWords;
	}

	public void writeIntoTheFile(List<Integer> content, File file) {
		try (FileWriter writer = new FileWriter(file);
			 BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
			for (int elem : content) {
				String str = Integer.toString(elem);
				bufferedWriter.write(str+" ");
			}
			bufferedWriter.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<Integer> generateRandomNumbers (int amountOfNumbers) {
		List<Integer> randomNumbers = new ArrayList<>();
		Random rand = new Random();
		for (int i=0; i<amountOfNumbers; i++) {
			randomNumbers.add(rand.nextInt(amountOfNumbers));
		}
		return randomNumbers;
	}

// for task2
    public List<String> readByLines (File file) {
        List<String> lines = new ArrayList<>();
        try (FileReader reader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(reader)) {
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public void outputList (List<String> list, File file) {
        try (FileWriter writer = new FileWriter(file);
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
            for (String str : list) {
                bufferedWriter.write(str);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeJavaProgram (String str, File file) {
        try (FileWriter writer = new FileWriter(file);
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
            bufferedWriter.write(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}