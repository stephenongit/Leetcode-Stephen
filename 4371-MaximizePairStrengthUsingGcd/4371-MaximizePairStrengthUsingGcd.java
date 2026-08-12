// Last updated: 8/12/2026, 12:04:12 PM
class Solution {
    public long maxPairStrength(int[] nums) {
     long a =  0;
        int n = nums.length;
        for(int i = 0; i<n; i++){
            for(int j = i+1; j<n; j++){
                long g = gcd(nums[i], nums[j]);
                long strength = (nums[i]/g) * (nums[j]/g);
                a = Math.max(a,strength);
            }
        }
        return a;
    }
    private long gcd(long c, long b){
        while(b != 0){
            long temp = b;
            b = c%b;
            c= temp;
        }
        return c;
    }
}