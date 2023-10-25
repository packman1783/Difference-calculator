package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class Stylish {
    public static String formatStylish(List<Map<String, Object>> diffList) throws Exception {
        StringBuilder result = new StringBuilder("{\n");

        for (Map<String, Object> diff : diffList) {
            switch (String.valueOf(diff.get("status"))) {
                case "deleted" -> {
                    result.append("  - " + diff.get("key") + ": " + diff.get("mapOneValue") + "\n");
                }
                case "added" -> {
                    result.append("  + " + diff.get("key") + ": " + diff.get("mapTwoValue") + "\n");
                }
                case "changed" -> {
                    result.append("  - " + diff.get("key") + ": " + diff.get("mapOneValue") + "\n");
                    result.append("  + " + diff.get("key") + ": " + diff.get("mapTwoValue") + "\n");
                }
                case "unchanged" -> {
                    result.append("    " + diff.get("key") + ": " + diff.get("mapOneValue") + "\n");
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
