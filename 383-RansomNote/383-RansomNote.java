// Last updated: 12/08/2026, 19:12:42
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {

        int[] count = new int[26];

        for (char c : magazine.toCharArray())
            count[c - 'a']++;

        for (char c : ransomNote.toCharArray()) {
            if (--count[c - 'a'] < 0)
                return false;
        }

        return true;
    }
}