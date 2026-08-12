// Last updated: 12/08/2026, 19:12:18
class Solution {
    public int countSegments(String s) {
        s = s.trim();

        if (s.isEmpty())
            return 0;

        return s.split("\\s+").length;
    }
}