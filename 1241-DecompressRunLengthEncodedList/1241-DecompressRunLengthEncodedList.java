// Last updated: 12/08/2026, 19:08:04
class Solution {
    public int[] decompressRLElist(int[] nums) {

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i += 2) {
            int freq = nums[i];
            int val = nums[i + 1];

            while (freq-- > 0)
                list.add(val);
        }

        int[] ans = new int[list.size()];

        for (int i = 0; i < ans.length; i++)
            ans[i] = list.get(i);

        return ans;
    }
}