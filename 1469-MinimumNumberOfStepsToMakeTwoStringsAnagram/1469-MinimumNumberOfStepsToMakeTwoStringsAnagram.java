// Last updated: 8/12/2026, 12:13:08 PM
class Solution {
    public int minSteps(String s, String t) {

        int[] count = new int[26];

        for (char c : s.toCharArray())
            count[c - 'a']++;

        for (char c : t.toCharArray())
            count[c - 'a']--;

        int ans = 0;

        for (int x : count) {
            if (x > 0)
                ans += x;
        }

        return ans;
    }
}