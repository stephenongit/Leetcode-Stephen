// Last updated: 8/12/2026, 12:04:41 PM
class Solution {
    public int getLength(int[] nums) {
        int[] dremovical = nums;
        int n = dremovical.length;
        int ans = 1;

        for (int i = 0; i < n; i++) {
            int[] freq = new int[n + 1];
            Map<Integer, Integer> elemToIdx = new HashMap<>();
            int[] idxFreq = new int[n + 1];

            Map<Integer, Integer> elemFreq = new HashMap<>();
            Map<Integer, Integer> freqCount = new HashMap<>();
            int maxFreq = 0, minFreq = 0;
            int distinct = 0;

            for (int j = i; j < n; j++) {
                int val = nums[j];
                int oldF = elemFreq.getOrDefault(val, 0);

                if (oldF > 0) {
                    int c = freqCount.get(oldF) - 1;
                    if (c == 0) freqCount.remove(oldF);
                    else freqCount.put(oldF, c);
                } else {
                    distinct++;
                }

                int newF = oldF + 1;
                elemFreq.put(val, newF);
                freqCount.put(newF, freqCount.getOrDefault(newF, 0) + 1);
                if (newF > maxFreq) maxFreq = newF;

                minFreq = maxFreq;
                for (int f : freqCount.keySet()) {
                    if (f < minFreq) minFreq = f;
                }

                if (isBalanced(distinct, freqCount.size(), maxFreq, minFreq)) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }

        return ans;
    }

    private boolean isBalanced(int distinct, int distinctFreqs, int maxFreq, int minFreq) {
        if (distinct == 1) return true;
        if (distinctFreqs != 2) return false;
        return maxFreq == 2 * minFreq;
    }
}