package hexlet.code.format;

import java.util.List;
import java.util.Map;

public class Stylish {
    public static String formatStylish(List<Map<String, Object>> diffList) {
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
                default -> {
                    result.append("    " + diff.get("key") + ": " + diff.get("mapOneValue") + "\n");
                }
            }
        }

        result.append("}");
        return result.toString();
    }
}
