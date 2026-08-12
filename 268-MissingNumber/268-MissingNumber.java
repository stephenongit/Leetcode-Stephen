// Last updated: 12/08/2026, 19:13:20
class Solution {
    public int missingNumber(int[] nums) {

        int xor = nums.length;

        for (int i = 0; i < nums.length; i++)
            xor ^= i ^ nums[i];

        return xor;
    }
}