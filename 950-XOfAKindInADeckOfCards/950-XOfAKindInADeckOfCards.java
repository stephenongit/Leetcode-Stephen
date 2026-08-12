// Last updated: 12/08/2026, 19:09:11
import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        // Step 1: Count the frequency of each card
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int card : deck) {
            countMap.put(card, countMap.getOrDefault(card, 0) + 1);
        }
        
        // Step 2: Find the GCD of all frequencies
        int overallGcd = 0;
        for (int count : countMap.values()) {
            overallGcd = gcd(overallGcd, count);
            
            // Optimization: If GCD becomes 1 at any point, we can never recover it to >= 2
            if (overallGcd == 1) {
                return false;
            }
        }
        
        // Step 3: Check if the greatest common divisor is at least 2
        return overallGcd >= 2;
    }
    
    // Helper method to calculate GCD using the Euclidean algorithm
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}        