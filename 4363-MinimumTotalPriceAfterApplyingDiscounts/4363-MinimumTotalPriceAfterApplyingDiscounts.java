// Last updated: 8/12/2026, 12:04:14 PM
import java.util.*;

class Solution {
    public double minPrice(int[] prices, int[] discounts) {
        Arrays.sort(prices);
        Arrays.sort(discounts);
        int i = prices.length - 1;
        int j = discounts.length - 1;

        double total = 0;
        while(i >= 0){
            if(j >= 0){
                total += prices[i] * (100.0 - discounts[j]) / 100;
                j--;
            }
            else{
                total += prices[i];
            }

            i--;
        }
        return total;
    }
}