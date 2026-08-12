// Last updated: 12/08/2026, 19:11:55
class Solution {
    public boolean detectCapitalUse(String word) {
        return word.equals(word.toUpperCase()) ||
               word.equals(word.toLowerCase()) ||
               Character.isUpperCase(word.charAt(0)) &&
               word.substring(1).equals(word.substring(1).toLowerCase());
    }
}