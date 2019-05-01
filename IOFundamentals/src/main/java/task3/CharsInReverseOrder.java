package task3;

import task1.InputOutput;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CharsInReverseOrder {
    public static void main(String[] args) {
        String javaProgram = "public class Program {\n" +
                "    private String field = \"name1\";\n" +
                "    public String field2 = \"name2\";\n" +
                "    public String getField() {\n" +
                "        return field;\n" +
                "    }\n" +
                "    private String getField2() {\n" +
                "        return field2;\n" +
                "    }\n" +
                "    public void setField(String field) {\n" +
                "        this.field = field;\n" +
                "    }\n" +
                "}";

        InputOutput io = new InputOutput();
        io.createNewDir();
        File file = io.createNewFile("java", "task3");
        io.writeJavaProgram(javaProgram, file);
        List<String> list = io.readByLines(file);
        File fileWithReversedLines = io.createNewFile("java", "task3_reversed");
        io.outputList(reverseTheOrder(list), fileWithReversedLines);
    }

    private static List<String> reverseTheOrder (List<String> list) {
        StringBuilder sb = new StringBuilder();
        List<String> reversedLines = new ArrayList<>();
        for (String str : list) {
            for (int i = str.length() - 1; i >= 0; i--) {
                sb.append(str.charAt(i));
            }
            sb.append("\n");
        }
        reversedLines.add(sb.toString());
        return  reversedLines;
    }
}
