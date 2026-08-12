// Last updated: 12/08/2026, 19:12:11
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        return (s + s).substring(1, 2 * s.length() - 1).contains(s);
    }
}