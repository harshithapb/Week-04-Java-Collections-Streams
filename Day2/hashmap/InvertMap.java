package hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InvertMap {

    public static <K, V> Map<V, List<K>> invertMap(Map<K, V> originalMap) {
        Map<V, List<K>> invertedMap = new HashMap<>();

        for (Map.Entry<K, V> entry : originalMap.entrySet()) {
            K key = entry.getKey();
            V value = entry.getValue();

            // If the value is already a key in the inverted map, add the current key to its list
            if (invertedMap.containsKey(value)) {
                invertedMap.get(value).add(key);
            } else {
                // If the value is not yet a key, create a new list with the current key
                List<K> keysForValue = new ArrayList<>();
                keysForValue.add(key);
                invertedMap.put(value, keysForValue);
            }
        }

        return invertedMap;
    }

    public static void main(String[] args) {
        Map<String, Integer> originalMap = new HashMap<>();
        originalMap.put("A", 1);
        originalMap.put("B", 2);
        originalMap.put("C", 1);
        originalMap.put("D", 3);
        originalMap.put("E", 2);

        Map<Integer, List<String>> invertedMap = invertMap(originalMap);

        System.out.println("Original Map: " + originalMap);
        System.out.println("Inverted Map: " + invertedMap);
    }
}