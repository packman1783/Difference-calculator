package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class Stylish {
    public static String format(List<Map<String, Object>> diffList) throws Exception {
        StringBuilder result = new StringBuilder("{\n");

        for (Map<String, Object> diff : diffList) {
            switch (String.valueOf(diff.get("status"))) {
                case "deleted" -> result.append(String.format("  - %s: %s\n", diff.get("key"), diff.get("Value1")));
                case "added" -> result.append(String.format("  + %s: %s\n", diff.get("key"), diff.get("Value2")));
                case "changed" -> {
                    result.append(String.format("  - %s: %s\n", diff.get("key"), diff.get("Value1")));
                    result.append(String.format("  + %s: %s\n", diff.get("key"), diff.get("Value2")));
                }
                case "unchanged" -> result.append(String.format("    %s: %s\n", diff.get("key"), diff.get("Value1")));
                default -> throw new Exception("Status: " + diff.get("status") + " is incorrect!");
            }
        }

        result.append("}");
        return result.toString();
    }
}
