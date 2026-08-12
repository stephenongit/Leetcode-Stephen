// Last updated: 12/08/2026, 19:11:44
class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder ans = new StringBuilder();

        for (String word : words) {
            ans.append(new StringBuilder(word).reverse()).append(" ");
        }

        return ans.toString().trim();
    }
}