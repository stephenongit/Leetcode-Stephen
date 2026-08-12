// Last updated: 12/08/2026, 19:14:06
class Solution {
    public boolean containsDuplicate(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {

            if (!set.add(num))
                return true;
        }

        return false;
    }
}