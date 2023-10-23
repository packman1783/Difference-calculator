package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class Differ {

    public static String generate(String filePathOne, String filePathTwo) throws Exception {
        String formatFile1 = getFormat(filePathOne);
        String formatFile2 = getFormat(filePathTwo);

        Path firstFilePath = getPath(filePathOne);
        Path secondFilePath = getPath(filePathTwo);

        String contentFileOne = Files.readString(firstFilePath);
        String contentFileTwo = Files.readString(secondFilePath);

        Map<String, Object> fileMapOne = Parser.parseToMap(contentFileOne, formatFile1);
        Map<String, Object> fileMapTwo = Parser.parseToMap(contentFileTwo, formatFile2);

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

    public static Path getPath(String filePath) throws Exception {
        return Paths.get(filePath).toAbsolutePath().normalize();
    }

    public static String getFormat(String filePath) throws Exception {
        if (filePath.endsWith(".json")) {
            return "json";
        } else if (filePath.endsWith(".yml")) {
            return "yml";
        } else {
            throw new Exception("File format" + filePath + "not supported");
        }
    }
}
