// Last updated: 8/12/2026, 12:14:48 PM
import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {

            char[] chars = s.toCharArray();

            Arrays.sort(chars);

            String key = new String(chars);

            map.putIfAbsent(key, new ArrayList<>());

            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }
}