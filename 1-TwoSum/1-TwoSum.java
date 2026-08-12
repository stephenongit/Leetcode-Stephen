// Last updated: 8/12/2026, 12:16:52 PM
class Solution {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int diff = target - nums[i];

            if (map.containsKey(diff))
                return new int[]{map.get(diff), i};

            map.put(nums[i], i);
        }

        return new int[]{};
    }
}