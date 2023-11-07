package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class Plain {
    public static String format(List<Map<String, Object>> diffList) throws Exception {
        StringBuilder result = new StringBuilder();

        for (Map<String, Object> diff : diffList) {
            Object key = diff.get("key");
            Object value1 = diff.get("value1");
            Object value2 = diff.get("value2");
            switch (String.valueOf(diff.get("status"))) {
                case "deleted" -> result.append(String.format("Property '%s' was removed\n", key));
                case "added" -> result.append(String.format("Property '%s' was added with value: %s\n", key,
                        treeValue(value2)));
                case "changed" -> result.append(String.format("Property '%s' was updated. From %s to %s\n", key,
                        treeValue(value1), treeValue(value2)));
                case "unchanged" -> {
                }
                default -> throw new Exception("Status: " + diff.get("status") + " is incorrect!");
            }
        }

        return result.toString().trim();
    }

    public static String treeValue(Object value) {
        if (value instanceof String) {
            return "'" + value + "'";
        } else if (value instanceof List<?> || value instanceof Map<?, ?>) {
            return "[complex value]";
        }

        return String.valueOf(value);
    }
}
