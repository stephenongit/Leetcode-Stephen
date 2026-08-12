// Last updated: 8/12/2026, 12:14:04 PM
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();

            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i)
                    row.add(1);
                else
                    row.add(ans.get(i - 1).get(j - 1) + ans.get(i - 1).get(j));
            }

            ans.add(row);
        }

        return ans;
    }
}