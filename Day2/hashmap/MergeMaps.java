package hashmap;


import java.util.HashMap;
import java.util.Map;

public class MergeMaps {

    public static Map<String, Integer> mergeMaps(Map<String, Integer> map1, Map<String, Integer> map2) {
        Map<String, Integer> mergedMap = new HashMap<>(map1); // Start with a copy of map1

        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();

            if (mergedMap.containsKey(key)) {
                // If the key exists in both maps, sum their values
                mergedMap.put(key, mergedMap.get(key) + value);
            } else {
                // If the key only exists in map2, add it to the merged map
                mergedMap.put(key, value);
            }
        }

        return mergedMap;
    }

    public static void main(String[] args) {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("B", 3);
        map2.put("C", 4);

        Map<String, Integer> mergedResult = mergeMaps(map1, map2);

        System.out.println("Map1: " + map1);
        System.out.println("Map2: " + map2);
        System.out.println("Merged Map: " + mergedResult);

        Map<String, Integer> map3 = new HashMap<>();
        map3.put("X", 10);
        map3.put("Y", 20);

        Map<String, Integer> map4 = new HashMap<>();
        map4.put("Y", 30);
        map4.put("Z", 40);
        map4.put("X", 15);

        Map<String, Integer> mergedResult2 = mergeMaps(map3, map4);
        System.out.println("\nMap3: " + map3);
        System.out.println("Map4: " + map4);
        System.out.println("Merged Map 2: " + mergedResult2);
    }
}
