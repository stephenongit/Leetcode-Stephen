// Last updated: 8/12/2026, 12:11:21 PM
import java.util.*;

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        Map<Integer, Long> map = new HashMap<>();
        long prefix = 0;
        long ans = Long.MIN_VALUE;

        for (int x : nums) {
            if (map.containsKey(x - k))
                ans = Math.max(ans, prefix + x - map.get(x - k));

            if (map.containsKey(x + k))
                ans = Math.max(ans, prefix + x - map.get(x + k));

            map.put(x, Math.min(
                map.getOrDefault(x, Long.MAX_VALUE),
                prefix
            ));

            prefix += x;
        }

        return ans == Long.MIN_VALUE ? 0 : ans;
    }
}