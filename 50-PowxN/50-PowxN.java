// Last updated: 8/12/2026, 12:14:52 PM
class Solution {
    public double myPow(double x, int n) {
        long N = n;

        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        double result = 1;

        while (N > 0) {
            if ((N & 1) == 1) {
                result *= x;
            }

            x *= x;
            N >>= 1;
        }

        return result;
    }
}