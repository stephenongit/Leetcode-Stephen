// Last updated: 12/08/2026, 19:15:08
class Solution {
    public int majorityElement(int[] nums) {
        int candidate = 0, count = 0;

        for (int num : nums) {
            if (count == 0)
                candidate = num;

            if (num == candidate)
                count++;
            else
                count--;
        }

        return candidate;
    }
}