// Last updated: 12/08/2026, 19:09:05
class Solution {
    public int maxSubarraySumCircular(int[] nums) {

        int total = 0;

        int maxSum = nums[0];
        int currentMax = nums[0];

        int minSum = nums[0];
        int currentMin = nums[0];

        for (int i = 0; i < nums.length; i++) {

            if (i > 0) {
                currentMax = Math.max(nums[i], currentMax + nums[i]);
                maxSum = Math.max(maxSum, currentMax);

                currentMin = Math.min(nums[i], currentMin + nums[i]);
                minSum = Math.min(minSum, currentMin);
            }

            total += nums[i];
        }

        // All numbers are negative
        if (maxSum < 0)
            return maxSum;

        return Math.max(maxSum, total - minSum);
    }
}