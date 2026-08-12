// Last updated: 8/12/2026, 12:13:49 PM
class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;

        for (int num : nums)
            ans ^= num;

        return ans;
    }
}