// Last updated: 8/12/2026, 12:11:42 PM
import java.util.*;

class Solution {
    public int maximumSetSize(int[] nums1, int[] nums2) {

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int x : nums1)
            set1.add(x);

        for (int x : nums2)
            set2.add(x);

        int n = nums1.length / 2;

        int unique1 = 0;
        int unique2 = 0;
        int common = 0;

        for (int x : set1) {
            if (set2.contains(x))
                common++;
            else
                unique1++;
        }

        for (int x : set2) {
            if (!set1.contains(x))
                unique2++;
        }

        int take1 = Math.min(unique1, n);
        int take2 = Math.min(unique2, n);

        int remaining = common;

        int slots1 = n - take1;
        int use1 = Math.min(slots1, remaining);

        take1 += use1;
        remaining -= use1;

        int slots2 = n - take2;
        int use2 = Math.min(slots2, remaining);

        take2 += use2;

        return take1 + take2;
    }
}