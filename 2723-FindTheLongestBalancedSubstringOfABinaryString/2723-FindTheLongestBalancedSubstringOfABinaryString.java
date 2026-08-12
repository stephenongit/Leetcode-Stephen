// Last updated: 8/12/2026, 12:11:54 PM
class Solution {
    public int findTheLongestBalancedSubstring(String s) {
        int zeros = 0;
        int ones = 0;
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                if (i > 0 && s.charAt(i - 1) == '1') {
                    zeros = 0;
                }
                zeros++;
            } else {
                ones++;
                ans = Math.max(ans, 2 * Math.min(zeros, ones));
                if (i + 1 < s.length() && s.charAt(i + 1) == '0') {
                    ones = 0;
                }
            }
        }

        return ans;
    }
}