package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class Plain {
    public static String formatPlain(List<Map<String, Object>> diffList) throws Exception {
        StringBuilder result = new StringBuilder();

        for (Map<String, Object> diff : diffList) {
            Object key = diff.get("key");
            Object value1 = diff.get("mapOneValue");
            Object value2 = diff.get("mapTwoValue");
            switch (String.valueOf(diff.get("status"))) {
                case "deleted" -> {
                    result.append("Property " + "'" + key + "'" + " was removed" + "\n");
                }
                case "added" -> {
                    result.append("Property " + "'" + key + "'" + " was added with value: " + treeValue(value2) + "\n");
                }
                case "changed" -> {
                    result.append("Property " + "'" + key + "'" + " was updated. From " + treeValue(value1) + " to "
                            + treeValue(value2) + "\n");
                }
                case "unchanged" -> {
                }
                default -> {
                    throw new Exception("Status: " + diff.get("status") + " is incorrect!");
                }
            }
        }

        return result.toString().trim();
    }

    public static String treeValue(Object value) {
        if (value == null) {
            return "null";
        } else if (value instanceof String) {
            return "'" + value + "'";
        } else if (value instanceof List<?> || value instanceof Map<?, ?>) {
            return "[complex value]";
        }

        return String.valueOf(value);
    }
}
