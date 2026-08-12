// Last updated: 12/08/2026, 19:08:09
import java.util.Stack;

public class Solution {
    public int mctFromLeafValues(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        // Push a placeholder maximum value to handle boundary checks easily
        stack.push(Integer.MAX_VALUE);
        int totalCost = 0;
        
        for (int num : arr) {
            // While the current number is greater than or equal to the top of the stack,
            // the top of the stack is a local minimum and can be eliminated.
            while (stack.peek() <= num) {
                int mid = stack.pop();
                // Multiply mid with the smaller of its two neighbors:
                // stack.peek() (left neighbor) or num (right neighbor)
                totalCost += mid * Math.min(stack.peek(), num);
            }
            stack.push(num);
        }
        
        // Collapse the remaining elements in the stack
        while (stack.size() > 2) {
            int mid = stack.pop();
            totalCost += mid * stack.peek();
        }
        
        return totalCost;
    }
}