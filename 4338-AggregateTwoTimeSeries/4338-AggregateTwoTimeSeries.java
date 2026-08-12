// Last updated: 8/12/2026, 12:04:27 PM
class Solution {
    public List<List<Integer>> aggregateTimeSeries(int[][] series1, int[][] series2) {
        Object a = new Object[]{series1, series2};
        int n = series1.length;
        int m = series2.length;
        List<List<Integer>> answer = new ArrayList<>();
        int i = 0, j = 0;
        while(i < n || j < m){
            int timestamp;
            if(i == n){
                timestamp = series2[j][0];
            }
            else if(j == m){
                timestamp = series1[i][0];
            }
            else{
                timestamp = Math.min(series1[i][0], series2[j][0]);
            }
            int value1 = (i < n) ? series1[i][1] : 0;
            int value2 = (j < m) ? series2[j][1] : 0;
            answer.add(Arrays.asList(timestamp, value1 + value2));
            if(i < n && series1[i][0] == timestamp){
                i++;
            }
            if(j < m && series2[j][0] == timestamp){
                j++;
            }
            if(j < m && series2[j][0] == timestamp){
                j++;
            }
        }
        return answer;
    }
}