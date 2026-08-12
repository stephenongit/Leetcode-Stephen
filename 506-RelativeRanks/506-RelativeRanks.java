// Last updated: 12/08/2026, 19:11:57
import java.util.Arrays;

class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String[] result = new String[n];
        
        // Create an array of indices [0, 1, 2, ..., n-1]
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        
        // Sort indices based on their corresponding scores in descending order
        Arrays.sort(indices, (a, b) -> Integer.compare(score[b], score[a]));
        
        // Assign ranks based on the sorted positions
        for (int i = 0; i < n; i++) {
            int originalIndex = indices[i];
            
            if (i == 0) {
                result[originalIndex] = "Gold Medal";
            } else if (i == 1) {
                result[originalIndex] = "Silver Medal";
            } else if (i == 2) {
                result[originalIndex] = "Bronze Medal";
            } else {
                result[originalIndex] = String.valueOf(i + 1);
            }
        }
        
        return result;
    }
}