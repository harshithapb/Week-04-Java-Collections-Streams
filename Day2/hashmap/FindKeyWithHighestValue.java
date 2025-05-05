package hashmap;


import java.util.HashMap;
import java.util.Map;

public class FindKeyWithHighestValue {

    public static String findKeyWithMaxValue(Map<String, Integer> map) {
        if (map == null || map.isEmpty()) {
            return null; // Or throw an exception if an empty map is not allowed
        }

        String maxKey = null;
        Integer maxValue = null;

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String currentKey = entry.getKey();
            Integer currentValue = entry.getValue();

            if (maxValue == null || currentValue > maxValue) {
                maxValue = currentValue;
                maxKey = currentKey;
            }
        }

        return maxKey;
    }

    public static void main(String[] args) {
        Map<String, Integer> data = new HashMap<>();
        data.put("A", 10);
        data.put("B", 20);
        data.put("C", 15);
        data.put("D", 5);
        data.put("E", 25);

        String keyWithMax = findKeyWithMaxValue(data);

        if (keyWithMax != null) {
            System.out.println("Input: " + data);
            System.out.println("Key with the highest value: " + keyWithMax);
        } else {
            System.out.println("The map is empty.");
        }

        // Example with an empty map
        Map<String, Integer> emptyMap = new HashMap<>();
        String keyWithMaxEmpty = findKeyWithMaxValue(emptyMap);
        System.out.println("\nInput: " + emptyMap);
        System.out.println("Key with the highest value: " + keyWithMaxEmpty);
    }
}
