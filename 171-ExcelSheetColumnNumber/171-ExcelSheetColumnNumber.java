// Last updated: 12/08/2026, 19:15:07
class Solution {
    public int titleToNumber(String columnTitle) {
        int result = 0;

        for (char c : columnTitle.toCharArray()) {
            result = result * 26 + (c - 'A' + 1);
        }

        return result;
    }
}