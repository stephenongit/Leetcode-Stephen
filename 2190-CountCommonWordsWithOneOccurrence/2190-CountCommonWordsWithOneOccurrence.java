// Last updated: 8/12/2026, 12:12:05 PM
import java.util.*;

class Solution {
    public int countWords(String[] words1, String[] words2) {
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();

        for (String word : words1)
            map1.put(word, map1.getOrDefault(word, 0) + 1);

        for (String word : words2)
            map2.put(word, map2.getOrDefault(word, 0) + 1);

        int count = 0;

        for (String key : map1.keySet()) {
            if (map1.get(key) == 1 && map2.getOrDefault(key, 0) == 1)
                count++;
        }

        return count;
    }
}