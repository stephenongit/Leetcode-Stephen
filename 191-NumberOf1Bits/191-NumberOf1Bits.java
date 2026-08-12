// Last updated: 12/08/2026, 19:14:30
public class Solution {
    public int hammingWeight(int n) {
        int count = 0;

        while (n != 0) {
            count += (n & 1);
            n >>>= 1;
        }

        return count;
    }
}