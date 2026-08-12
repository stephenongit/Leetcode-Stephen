// Last updated: 12/08/2026, 19:07:49
import java.util.*;

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        HashSet<Integer> uniqueCounts = new HashSet<>(frequencyMap.values());
        return frequencyMap.size() == uniqueCounts.size();
    }
}