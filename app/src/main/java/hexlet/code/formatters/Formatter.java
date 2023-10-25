package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class Formatter {
    public static String formatToString(List<Map<String, Object>> diffList, String format) throws Exception {
        return switch (format) {
            case "stylish" -> Stylish.formatStylish(diffList);
            case "plain" -> Plain.formatPlain(diffList);
            default -> throw new IllegalStateException("Unexpected value: " + format);
        };
    }
}

