package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class Plain {
    public static String format(List<Map<String, Object>> diffList) throws Exception {
        StringBuilder result = new StringBuilder();

        for (Map<String, Object> diff : diffList) {
            Object key = diff.get("key");
            Object value1 = diff.get("Value1");
            Object value2 = diff.get("Value2");
            switch (String.valueOf(diff.get("status"))) {
                case "deleted" -> {
                    result.append("Property " + "'").append(key).append("'").append(" was removed").append("\n");
                }
                case "added" -> {
                    result.append("Property " + "'").append(key).append("'").append(" was added with value: ")
                            .append(treeValue(value2)).append("\n");
                }
                case "changed" -> {
                    result.append("Property " + "'").append(key).append("'").append(" was updated. From ")
                            .append(treeValue(value1)).append(" to ").append(treeValue(value2)).append("\n");
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
        if (value instanceof String) {
            return "'" + value + "'";
        } else if (value instanceof List<?> || value instanceof Map<?, ?>) {
            return "[complex value]";
        }

        return String.valueOf(value);
    }
}
