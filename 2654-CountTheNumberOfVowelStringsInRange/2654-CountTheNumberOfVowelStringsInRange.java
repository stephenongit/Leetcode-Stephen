// Last updated: 8/12/2026, 12:11:57 PM
class Solution {
    public int vowelStrings(String[] words, int left, int right) {
        int count = 0;

        for (int i = left; i <= right; i++) {
            String s = words[i];
            char first = s.charAt(0);
            char last = s.charAt(s.length() - 1);

            if (isVowel(first) && isVowel(last))
                count++;
        }

        return count;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' ||
               c == 'o' || c == 'u';
    }
}