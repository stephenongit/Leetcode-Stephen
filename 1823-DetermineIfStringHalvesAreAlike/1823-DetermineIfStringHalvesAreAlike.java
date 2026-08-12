// Last updated: 8/12/2026, 12:12:34 PM
class Solution {
    public boolean halvesAreAlike(String s) {
        String vowels = "aeiouAEIOU";
        int left = 0, right = 0;
        int n = s.length();

        for (int i = 0; i < n / 2; i++) {
            if (vowels.indexOf(s.charAt(i)) != -1)
                left++;
        }

        for (int i = n / 2; i < n; i++) {
            if (vowels.indexOf(s.charAt(i)) != -1)
                right++;
        }

        return left == right;
    }
}