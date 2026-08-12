// Last updated: 8/12/2026, 12:14:00 PM
import java.util.*;

class Solution {
    public int longestConsecutive(int[] nums) {

        Set<Integer> set = new HashSet<>();

        for (int x : nums)
            set.add(x);

        int longest = 0;

        for (int x : set) {

            if (!set.contains(x - 1)) {

                int current = x;
                int length = 1;

                while (set.contains(current + 1)) {
                    current++;
                    length++;
                }

                longest = Math.max(longest, length);
            }
        }

        return longest;
    }
}