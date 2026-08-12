// Last updated: 8/12/2026, 12:12:18 PM
class Solution {
    public boolean makeEqual(String[] words) {
        int[] count = new int[26];

        for (String word : words) {
            for (char c : word.toCharArray()) {
                count[c - 'a']++;
            }
        }

        for (int x : count) {
            if (x % words.length != 0)
                return false;
        }

        return true;
    }
}