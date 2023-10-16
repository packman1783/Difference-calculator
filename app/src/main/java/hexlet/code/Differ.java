package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class Differ {

    public static String generate(String filePathOne, String filePathTwo) throws Exception {
        Path firstFilePath = makePath(filePathOne);
        Path secondFilePath = makePath(filePathTwo);

        String contentFileOne = Files.readString(firstFilePath);
        String contentFileTwo = Files.readString(secondFilePath);

        Map<String, Object> fileMapOne = Parser.parse(contentFileOne);
        Map<String, Object> fileMapTwo = Parser.parse(contentFileTwo);

        Map<String, String> resultStringMap = Comparator.getDifference(fileMapOne, fileMapTwo);

        StringBuilder resultString = new StringBuilder("{\n");
        for (Map.Entry<String, String> resultStrMap : resultStringMap.entrySet()) {
            resultString
                    .append(" ")
                    .append(resultStrMap.getKey())
                    .append(": ")
                    .append(resultStrMap.getValue())
                    .append("\n");
        }
        resultString.append("}");

        return resultString.toString();
    }

    public static Path makePath(String pathString) throws Exception{
        return Paths.get(pathString).toAbsolutePath().normalize();
    }
}
