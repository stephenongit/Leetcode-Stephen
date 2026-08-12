// Last updated: 12/08/2026, 19:08:45
import java.util.LinkedList;
import java.util.List;

class Solution {
    /**
     * Adds the integer k to the array-form of the integer num and returns the array-form of the result.
     * @param num The array-form of the integer.
     * @param k The integer to add.
     * @return The array-form of num + k.
     */
    public List<Integer> addToArrayForm(int[] num, int k) {
        // Use a LinkedList for O(1) time complexity when prepending (addFirst) elements, 
        // which naturally builds the result in left-to-right order.
        LinkedList<Integer> result = new LinkedList<>();
        
        // Start iterating from the last digit of the num array.
        int i = num.length - 1; 

        // The loop continues as long as there are digits left in num OR
        // there are digits left in k (k > 0).
        while (i >= 0 || k > 0) {
            
            // 1. Add the current digit from num if we haven't exhausted the array.
            if (i >= 0) {
                k += num[i];
                i--;
            }
            
            // 2. Get the current digit for the result: the remainder (k % 10).
            int currentDigit = k % 10;
            
            // 3. Prepend the digit to the front of the result list.
            result.addFirst(currentDigit);
            
            // 4. Update k for the next iteration: the carry-over (k / 10).
            // This is the core mechanism that handles both the remaining digits of 
            // the original k and any carry from the addition.
            k /= 10;
        }
        
        return result;
    }
}