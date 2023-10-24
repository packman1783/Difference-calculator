package hexlet.code;

import java.util.*;

public class Comparator {
    public static List<Map<String, Object>> getDifference(Map<String, Object> mapOne, Map<String, Object> mapTwo) {
        List<Map<String, Object>> diffList = new LinkedList<>();

        Set<String> keys = new TreeSet<>(mapOne.keySet());
        keys.addAll(mapTwo.keySet());

        for (String key : keys) {
            Map<String, Object> innerMap = new HashMap<>();
                innerMap.put("key", key);
            if (!mapTwo.containsKey(key)) {
                innerMap.put("mapOneValue", mapOne.get(key));
                innerMap.put("status", "deleted");
            } else if (!mapOne.containsKey(key)) {
                innerMap.put("mapTwoValue", mapTwo.get(key));
                innerMap.put("status", "added");
            } else if (!Objects.equals(mapOne.get(key), mapTwo.get(key))) {
                innerMap.put("mapOneValue", mapOne.get(key));
                innerMap.put("mapTwoValue", mapTwo.get(key));
                innerMap.put("status", "changed");
            } else {
                innerMap.put("mapOneValue", mapOne.get(key));
                innerMap.put("status", "unchanged");
            }

            diffList.add(innerMap);
        }

        return diffList;
    }
}
