// Last updated: 8/12/2026, 12:11:35 PM
import java.util.*;
class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        int maxFreq = 0;
        for (int num : nums) {
            int currentFreq = frequencyMap.getOrDefault(num, 0) + 1;
            frequencyMap.put(num, currentFreq);
            maxFreq = Math.max(maxFreq, currentFreq);
        }
        int totalElementsWithMaxFreq = 0;
        for (int freq : frequencyMap.values()) {
            if (freq == maxFreq) {
                totalElementsWithMaxFreq += maxFreq;
            }
        }

        return totalElementsWithMaxFreq;
    }
}