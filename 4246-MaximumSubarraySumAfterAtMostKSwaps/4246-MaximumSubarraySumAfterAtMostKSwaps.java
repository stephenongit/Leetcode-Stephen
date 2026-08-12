// Last updated: 8/12/2026, 12:04:49 PM
import java.util.*;

class Solution {

    static class FenwickTree {
        long[] tree;
        int n;

        FenwickTree(int n) {
            this.n = n;
            this.tree = new long[n + 1];
        }

        void update(int i, long delta) {
            for (; i <= n; i += i & -i) {
                tree[i] += delta;
            }
        }

        long query(int i) {
            long s = 0;
            for (; i > 0; i -= i & -i) {
                s += tree[i];
            }
            return s;
        }

        int findKth(int k) {
            int idx = 0;
            int bitMask = Integer.highestOneBit(n);
            for (int i = bitMask; i > 0; i >>= 1) {
                int nextIdx = idx + i;
                if (nextIdx <= n && tree[nextIdx] < k) {
                    idx = nextIdx;
                    k -= tree[idx];
                }
            }
            return idx + 1;
        }
    }

    private long getSumOfFirstK(FenwickTree cntTree, FenwickTree sumTree, int k, int[] revRank) {
        if (k <= 0) return 0;
        int idx = cntTree.findKth(k);
        long s = sumTree.query(idx - 1);
        long count = cntTree.query(idx - 1);
        s += (long) (k - count) * revRank[idx - 1];
        return s;
    }

    public long maxSum(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) return 0;

        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        int u = 0;
        if (n > 0) {
            u = 1;
            for (int i = 1; i < n; i++) {
                if (sorted[i] != sorted[i - 1]) {
                    sorted[u++] = sorted[i];
                }
            }
        }

        int[] revRank = new int[u];
        for (int i = 0; i < u; i++) {
            revRank[i] = sorted[i];
        }

        int[] ranks = new int[n];
        for (int i = 0; i < n; i++) {
            ranks[i] = Arrays.binarySearch(revRank, 0, u, nums[i]) + 1;
        }

        FenwickTree outCnt = new FenwickTree(u);
        FenwickTree outSum = new FenwickTree(u);
        for (int i = 0; i < n; i++) {
            outCnt.update(ranks[i], 1);
            outSum.update(ranks[i], nums[i]);
        }

        long maxGlobalSum = Long.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            FenwickTree inCnt = new FenwickTree(u);
            FenwickTree inSum = new FenwickTree(u);
            long windowSum = 0;

            for (int j = i; j < n; j++) {
                int val = nums[j];
                int r = ranks[j];
                inCnt.update(r, 1);
                inSum.update(r, val);
                outCnt.update(r, -1);
                outSum.update(r, -val);
                windowSum += val;

                int L = j - i + 1;
                int mLimit = Math.min(k, Math.min(L, n - L));
                
                int low = 1, high = mLimit, bestM = 0;
                while (low <= high) {
                    int mid = (low + high) >>> 1;
                    int outVal = revRank[outCnt.findKth(n - L - mid + 1) - 1];
                    int inVal = revRank[inCnt.findKth(mid) - 1];
                    if (outVal > inVal) {
                        bestM = mid;
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }

                long currentSum = windowSum;
                if (bestM > 0) {
                    long sIn = getSumOfFirstK(inCnt, inSum, bestM, revRank);
                    long totalOutSum = outSum.query(u);
                    long sOutPrefix = getSumOfFirstK(outCnt, outSum, n - L - bestM, revRank);
                    long sOut = totalOutSum - sOutPrefix;
                    currentSum = windowSum - sIn + sOut;
                }

                if (currentSum > maxGlobalSum) {
                    maxGlobalSum = currentSum;
                }
            }

            // Restore out-trees for next i
            for (int j = i; j < n; j++) {
                outCnt.update(ranks[j], 1);
                outSum.update(ranks[j], nums[j]);
            }
        }

        return maxGlobalSum;
    }
}