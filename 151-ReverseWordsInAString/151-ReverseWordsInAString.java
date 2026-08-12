// Last updated: 8/12/2026, 12:13:48 PM
class Solution {
    public String reverseWords(String s) {

        String[] words = s.trim().split("\\s+");

        StringBuilder result = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {

            result.append(words[i]);

            if (i != 0)
                result.append(" ");
        }

        return result.toString();
    }
}