class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        int haystackIndex = 0;
        while (haystackIndex+needle.length() <= haystack.length()) {
            if (isEqual(haystack, haystackIndex, needle)) {
                return haystackIndex;
            }
            haystackIndex++;
        }
        return -1;
    }
    
    private boolean isEqual(String haystack, int haystackIndex, String needle) {
        int needleIndex = 0;
        while (needleIndex<needle.length() && 
               haystack.charAt(haystackIndex)==needle.charAt(needleIndex)) {
            haystackIndex++;
            needleIndex++;
        }
        return needleIndex == needle.length();
    }
}
