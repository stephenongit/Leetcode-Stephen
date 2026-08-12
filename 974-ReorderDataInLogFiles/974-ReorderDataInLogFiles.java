// Last updated: 12/08/2026, 19:08:55
import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, new Comparator<String>() {
            @Override
            public int compare(String log1, String log2) {
                // Split each log into 2 parts: identifier and the remaining content
                String[] split1 = log1.split(" ", 2);
                String[] split2 = log2.split(" ", 2);
                
                boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
                boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
                
                // Case 1: Both are letter-logs
                if (!isDigit1 && !isDigit2) {
                    // Compare contents first
                    int cmp = split1[1].compareTo(split2[1]);
                    if (cmp != 0) {
                        return cmp;
                    }
                    // If contents are identical, compare identifiers
                    return split1[0].compareTo(split2[0]);
                }
                
                // Case 2: One is a letter-log, one is a digit-log
                if (!isDigit1 && isDigit2) {
                    return -1; // Letter-log comes first
                } else if (isDigit1 && !isDigit2) {
                    return 1;  // Digit-log comes second
                }
                
                // Case 3: Both are digit-logs
                // Return 0 to maintain their original relative order (stable sort)
                return 0;
            }
        });
        
        return logs;
    }
}