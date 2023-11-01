package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class Stylish {
    public static String format(List<Map<String, Object>> diffList) throws Exception {
        StringBuilder result = new StringBuilder("{\n");

        for (Map<String, Object> diff : diffList) {
            switch (String.valueOf(diff.get("status"))) {
                case "deleted" -> {
                    result.append("  - ").append(diff.get("key")).append(": ").append(diff.get("Value1")).append("\n");
                }
                case "added" -> {
                    result.append("  + ").append(diff.get("key")).append(": ").append(diff.get("Value2")).append("\n");
                }
                case "changed" -> {
                    result.append("  - ").append(diff.get("key")).append(": ").append(diff.get("Value1")).append("\n");
                    result.append("  + ").append(diff.get("key")).append(": ").append(diff.get("Value2")).append("\n");
                }
                case "unchanged" -> {
                    result.append("    ").append(diff.get("key")).append(": ").append(diff.get("Value1")).append("\n");
                }
                default -> {
                    throw new Exception("Status: " + diff.get("status") + " is incorrect!");
                }
            }
        }

        result.append("}");
        return result.toString();
    }
}
