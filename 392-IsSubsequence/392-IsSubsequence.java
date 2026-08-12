// Last updated: 12/08/2026, 19:12:31
class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0;

        for (int j = 0; j < t.length() && i < s.length(); j++) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
        }

        return i == s.length();
    }
}