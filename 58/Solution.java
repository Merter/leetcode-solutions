class Solution {
    public int lengthOfLastWord(String s) {
        int end = s.length()-1;
        while (s.charAt(end) == ' ') end--;
        int begin = end-1;
        while (begin>=0 && s.charAt(begin) != ' ') begin--;
        return end-begin;
    }
}
