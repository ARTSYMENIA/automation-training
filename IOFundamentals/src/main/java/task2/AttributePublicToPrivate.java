package task2;

import task1.InputOutput;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AttributePublicToPrivate {
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
        File file = io.createNewFile("java", "task2");
        io.writeJavaProgram(javaProgram, file);
        List<String> list = io.readByLines(file);
        List<String> listWithReplacedWords = new ArrayList<>(replaceAttribute(list, "public", "private"));
        File fileWithReplacedAttribute = io.createNewFile("java", "task2WithReplacedAttributes");
        io.outputList(listWithReplacedWords, fileWithReplacedAttribute);
    }

    private static List<String> replaceAttribute(List<String> list, String attributeToReplace, String attributeToInsert) {
        List<String> listWithReplacedAttribute = new ArrayList<>();
        for (String str : list) {
            if (str.contains("class")) {
                listWithReplacedAttribute.add(str);
            } else {
                String lineWithReplacedAttributes = str.replace(attributeToReplace, attributeToInsert);
                listWithReplacedAttribute.add(lineWithReplacedAttributes);
            }
        }
        return listWithReplacedAttribute;
    }
}
