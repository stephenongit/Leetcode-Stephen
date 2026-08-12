// Last updated: 8/12/2026, 12:13:10 PM
class Solution {
    public boolean checkIfExist(int[] arr) {

        HashSet<Integer> set = new HashSet<>();

        for (int num : arr) {

            if (set.contains(num * 2) || (num % 2 == 0 && set.contains(num / 2)))
                return true;

            set.add(num);
        }

        return false;
    }
}