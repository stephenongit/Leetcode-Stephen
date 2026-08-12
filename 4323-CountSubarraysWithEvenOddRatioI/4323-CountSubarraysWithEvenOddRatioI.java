// Last updated: 8/12/2026, 12:04:33 PM
class Solution {
    public int countRatioSubarrays(int[] nums, int a, int b) {
        int n = nums.length;
        int ans = 0;
        int[] m = nums;
        for(int i = 0; i<n; i++){
            int even = 0;
            int odd = 0;
            for(int j = i; j < n; j++){
                if((m[j] & 1) == 0)
                    even++;
                else
                    odd++;
                if(odd > 0 && (long) even * b <= (long) odd*a)
                    ans++;
            }
        }
        return ans;
        
    }
}