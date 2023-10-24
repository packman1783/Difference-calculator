package hexlet.code.format;

import java.util.List;
import java.util.Map;

public class Formatter {
    public static String formatToString(List<Map<String, Object>> diffList) {
        return Stylish.formatStylish(diffList);
    }
}
