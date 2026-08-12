// Last updated: 12/08/2026, 19:10:26
class Solution {
    public boolean hasAlternatingBits(int n) {
        int prev = n & 1;
        n >>= 1;

        while (n > 0) {
            int curr = n & 1;

            if (curr == prev)
                return false;

            prev = curr;
            n >>= 1;
        }

        return true;
    }
}