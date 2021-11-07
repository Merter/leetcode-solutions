class Solution {
    public int firstUniqChar(String s) {
        int[] charCounts = new int[26];
        for (char chr : s.toCharArray()) {
            charCounts[chr-'a']++;
        }
        for (int i=0; i<s.length(); i++) {
            if (charCounts[s.charAt(i)-'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
