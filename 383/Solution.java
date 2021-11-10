class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (magazine.length() < ransomNote.length()) {
            return false;
        }
        int[] charCounts = new int[26];
        for (char chr : magazine.toCharArray()) {
            charCounts[chr-'a']++;
        }
        for (char chr : ransomNote.toCharArray()) {
            if (charCounts[chr-'a'] == 0) {
                return false;
            }
            charCounts[chr-'a']--;
        }
        return true;
    }
}
