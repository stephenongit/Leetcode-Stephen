// Last updated: 8/12/2026, 12:12:51 PM
class Solution {
    public int maxPower(String s) {
        int max = 1, count = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
                max = Math.max(max, count);
            } else {
                count = 1;
            }
        }

        return max;
    }
}