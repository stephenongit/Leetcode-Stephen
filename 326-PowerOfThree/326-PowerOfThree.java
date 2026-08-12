// Last updated: 12/08/2026, 19:13:04
class Solution {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) return false;

        while (n % 3 == 0) {
            n /= 3;
        }

        return n == 1;
    }
}