package hexlet.code;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class CompareUtil {
    public static List<Map<String, Object>> getDifference(Map<String, Object> mapOne, Map<String, Object> mapTwo) {
        List<Map<String, Object>> diffList = new LinkedList<>();

        Set<String> keys = new TreeSet<>(mapOne.keySet());
        keys.addAll(mapTwo.keySet());

        for (String key : keys) {
            Map<String, Object> innerMap = new HashMap<>();
            innerMap.put("key", key);
            if (!mapTwo.containsKey(key)) {
                innerMap.put("Value1", mapOne.get(key));
                innerMap.put("status", "deleted");
            } else if (!mapOne.containsKey(key)) {
                innerMap.put("Value2", mapTwo.get(key));
                innerMap.put("status", "added");
            } else if (!Objects.equals(mapOne.get(key), mapTwo.get(key))) {
                innerMap.put("Value1", mapOne.get(key));
                innerMap.put("Value2", mapTwo.get(key));
                innerMap.put("status", "changed");
            } else {
                innerMap.put("Value1", mapOne.get(key));
                innerMap.put("status", "unchanged");
            }

            diffList.add(innerMap);
        }

        return diffList;
    }
}
