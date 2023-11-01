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
        Map<String, Object> data1 = getData(filePathOne);
        Map<String, Object> data2 = getData(filePathTwo);

        List<Map<String, Object>> diff = CompareUtil.getDifference(data1, data2);

        return Formatter.formatToString(diff, format);
    }

    public static Path getPath(String filePath) throws IOException {
        return Paths.get(filePath).toAbsolutePath().normalize();
    }

    public static String getExtension(String filePath) throws Exception {
        String extension = filePath.substring(filePath.lastIndexOf("."));
        if (extension.equals(".json")) {
            return "json";
        } else if (extension.equals(".yml")) {
            return "yml";
        } else {
            throw new Exception("File format " + filePath + " not supported");
        }
    }

    public static Map<String, Object> getData(String filePath) throws Exception {
        String extension = getExtension(filePath);
        Path path = getPath(filePath);
        String content = Files.readString(path);
        return Parser.parseToMap(content, extension);
    }
}

