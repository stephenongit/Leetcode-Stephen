// Last updated: 12/08/2026, 19:13:00
class Solution {
    public boolean isPowerOfFour(int n) {
        return n > 0 &&
               (n & (n - 1)) == 0 &&
               (n & 0x55555555) != 0;
    }
}