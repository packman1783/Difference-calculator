package hexlet.code;

import hexlet.code.formatters.Formatter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class Differ {
    public static String generate(String filePathOne, String filePathTwo) throws Exception {
        return generate(filePathOne, filePathTwo, "stylish");
    }

    public static String generate(String filePathOne, String filePathTwo, String format) throws Exception {
        String extensionFile1 = getExtension(filePathOne);
        String extensionFile2 = getExtension(filePathTwo);

        Path firstFilePath = getPath(filePathOne);
        Path secondFilePath = getPath(filePathTwo);

        String contentFileOne = Files.readString(firstFilePath);
        String contentFileTwo = Files.readString(secondFilePath);

        Map<String, Object> fileMapOne = Parser.parseToMap(contentFileOne, extensionFile1);
        Map<String, Object> fileMapTwo = Parser.parseToMap(contentFileTwo, extensionFile2);

        List<Map<String, Object>> resultStringList = Comparator.getDifference(fileMapOne, fileMapTwo);

        return Formatter.formatToString(resultStringList, format);
    }

    public static Path getPath(String filePath) throws IOException {
        return Paths.get(filePath).toAbsolutePath().normalize();
    }

    public static String getExtension(String filePath) throws Exception {
        if (filePath.endsWith(".json")) {
            return "json";
        } else if (filePath.endsWith(".yml")) {
            return "yml";
        } else {
            throw new Exception("File format " + filePath + " not supported");
        }
    }
}
