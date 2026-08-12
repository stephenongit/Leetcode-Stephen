// Last updated: 12/08/2026, 19:10:30
class Solution {

    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            if (s.charAt(left) != s.charAt(right))
                return check(s, left + 1, right) ||
                       check(s, left, right - 1);

            left++;
            right--;
        }

        return true;
    }

    private boolean check(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }
}