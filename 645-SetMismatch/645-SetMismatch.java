// Last updated: 12/08/2026, 19:10:40
class Solution {
    public int[] findErrorNums(int[] nums) {

        int[] freq = new int[nums.length + 1];

        int duplicate = -1;
        int missing = -1;

        for (int num : nums) {
            freq[num]++;
            if (freq[num] == 2)
                duplicate = num;
        }

        for (int i = 1; i <= nums.length; i++) {
            if (freq[i] == 0) {
                missing = i;
                break;
            }
        }

        return new int[]{duplicate, missing};
    }
}
