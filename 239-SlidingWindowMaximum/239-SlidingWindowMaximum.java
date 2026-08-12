// Last updated: 12/08/2026, 19:13:35
import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;

        int[] ans = new int[n - k + 1];

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {

            // Remove elements outside the window
            while (!deque.isEmpty() &&
                   deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            // Remove smaller elements
            while (!deque.isEmpty() &&
                   nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }

            deque.addLast(i);

            // Window is ready
            if (i >= k - 1)
                ans[i - k + 1] = nums[deque.peekFirst()];
        }

        return ans;
    }
}