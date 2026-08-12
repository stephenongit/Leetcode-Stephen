// Last updated: 8/12/2026, 12:04:57 PM
class Solution {
    public int[] countTasks(int[] tasks, int[] shifts) {
        int n = tasks.length;
        int m = shifts.length;
        int[] d = tasks;
        long[] pre = new long[n+1];
        for(int i = 0; i < n; i++){
            pre[i+1] = pre[i] + tasks[i];
        }
        long total = pre[n];
        long done = 0;
        int[] ans = new int[m];
        for(int i = 0; i < m; i++){
            done += shifts[i];
            if(done >= total){
                ans[i] = 0;
                done = 0;
                continue;
            }
            int l = 0, r = n;
            while(l < r){
                int mid = (l+r)/2;
                if(pre[mid] <= done)
                    l = mid + 1;
                else
                    r = mid;
            }
            ans[i] = n - (l-1);
        }
        return ans;
    }
    
}