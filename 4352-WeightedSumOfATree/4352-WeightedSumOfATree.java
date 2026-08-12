// Last updated: 8/12/2026, 12:04:15 PM
import java.util.*;
class Solution {
    public long weightedSum(int[] parent, int[] nums) {
        int n = parent.length;
        List<Integer>[] tree = new ArrayList[n];
        for(int i = 0; i < n; i++){
            tree[i] = new ArrayList<>();
        }
        for(int i = 1; i < n; i++){
            tree[parent[i]].add(i);
        }
        int[] depth = new int[n];
        depth[0] = 1;
        int height = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while(!queue.isEmpty()){
            int node = queue.poll();
            for(int child : tree[node]){
                depth[child] = depth[node]+1;
                height = Math.max(height,depth[child]);
                queue.offer(child);
            }
        }
        long ans = 0;
        for(int i = 0; i < n; i++){
            ans+= (long) nums[i] * (height - depth[i]+1);
        }
        return ans;
    }
    
}