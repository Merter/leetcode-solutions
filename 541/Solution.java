class Solution {
    public String reverseStr(String s, int k) {
        if (k==1) {
            return s;
        }
        char[] chars = s.toCharArray();
        if (k > s.length()) {
            reverseCharsInInclusiveRange(chars, 0, s.length()-1);
        } else {
            for (int i=0; i<s.length(); i+=(2*k)) {
                int begin = i;
                int end = Math.min(i+k-1, s.length()-1);
                reverseCharsInInclusiveRange(chars, begin, end);
            }            
        }
        return new String(chars);
    }
    
    private void reverseCharsInInclusiveRange(char[] chars, int begin, int end) {
        for (int i=begin; i<(end+begin+1)/2; i++) {
            char temp = chars[i];
            chars[i] = chars[begin+end-i];
            chars[begin+end-i] = temp;
        }
    }
}

