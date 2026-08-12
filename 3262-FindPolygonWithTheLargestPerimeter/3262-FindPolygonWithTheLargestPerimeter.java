// Last updated: 8/12/2026, 12:11:25 PM
class Solution {
    public long largestPerimeter(int[] nums) {

        Arrays.sort(nums);

        long sum = 0;

        for (int num : nums)
            sum += num;

        for (int i = nums.length - 1; i >= 2; i--) {

            sum -= nums[i];

            if (sum > nums[i])
                return sum + nums[i];
        }

        return -1;
    }
}