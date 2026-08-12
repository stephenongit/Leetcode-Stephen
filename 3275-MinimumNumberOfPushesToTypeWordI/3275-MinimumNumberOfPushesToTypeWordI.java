// Last updated: 8/12/2026, 12:11:14 PM
class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        int pushes = 0;

        for (int i = 0; i < n; i++) {
            pushes += i / 8 + 1;
        }

        return pushes;
    }
}