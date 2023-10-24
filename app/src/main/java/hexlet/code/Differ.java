package hexlet.code;

import hexlet.code.format.Formatter;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
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

        List<Map<String, Object>> resultStringList = Comparator.getDifference(fileMapOne, fileMapTwo);

        return Formatter.formatToString(resultStringList);
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
