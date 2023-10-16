package hexlet.code;

import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.TreeSet;
import java.util.Objects;

public class Comparator {
    public static Map<String, String> getDifference(Map<String, Object> mapOne, Map<String, Object> mapTwo) {
        Map<String, String> resultMap = new LinkedHashMap<>();

        Set<String> keys = new TreeSet<>(mapOne.keySet());
        keys.addAll(mapTwo.keySet());

        for (String key : keys) {
            if (!mapOne.containsKey(key)) {
                resultMap.put("+ " + key, mapTwo.get(key).toString());
            } else if (!mapTwo.containsKey(key)) {
                resultMap.put("- " + key, mapOne.get(key).toString());
            } else if (Objects.equals(mapOne.get(key), mapTwo.get(key))) {
                resultMap.put("  " + key, mapOne.get(key).toString());
            } else if (!Objects.equals(mapOne.get(key), mapTwo.get(key))) {
                resultMap.put("- " + key, mapOne.get(key).toString());
                resultMap.put("+ " + key, mapTwo.get(key).toString());
            }
        }

        return resultMap;
    }
}
