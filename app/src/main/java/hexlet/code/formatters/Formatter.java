package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class Formatter {
    public static String formatToString(List<Map<String, Object>> diffList, String format) throws Exception {
        return switch (format) {
            case "stylish" -> Stylish.format(diffList);
            case "plain" -> Plain.format(diffList);
            case "json" -> Json.format(diffList);
            default -> throw new RuntimeException("Unexpected value: " + format);
        };
    }
}

