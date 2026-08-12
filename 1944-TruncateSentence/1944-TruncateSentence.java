// Last updated: 8/12/2026, 12:12:30 PM
class Solution {
    public String truncateSentence(String s, int k) {
        String[] words = s.split(" ");
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < k; i++) {
            ans.append(words[i]);
            if (i != k - 1)
                ans.append(" ");
        }

        return ans.toString();
    }
}