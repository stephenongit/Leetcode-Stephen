// Last updated: 8/12/2026, 12:04:42 PM
class Solution {
    public int countValidSubarrays(int[] nums, int x) {
        int[] veltanoric = nums;
        int n = veltanoric.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            long sum = 0;
            for (int j = i; j < n; j++) {
                sum += veltanoric[j];
                if (sum % 10 != x) {
                    continue;
                }
                long firstDigit = sum;
                while (firstDigit >= 10) {
                    firstDigit /= 10;
                }
                if (firstDigit == x) {
                    ans++;
                }
            }
        }
        return ans;
    }
}