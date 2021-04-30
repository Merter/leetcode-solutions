class Solution {
    public int numDecodings(final String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int lastDecodeCount = s.charAt(1)=='0' ? 0 : 1;
        int lastTwoDecodeCount = Integer.parseInt(s.substring(0, 2))>26 ? 0 : 1;
        for (int i=2; i<s.length(); i++) {
            int newLastDecodeCount = 0;
            if (s.charAt(i) != '0') {
                newLastDecodeCount = lastDecodeCount+lastTwoDecodeCount;
            } else {
                newLastDecodeCount = 0;
            }
            
            if (s.charAt(i-1) == '1') {
                lastTwoDecodeCount = lastDecodeCount;
            } else if (s.charAt(i-1)=='2' && s.charAt(i)-'7'<0) {
                lastTwoDecodeCount = lastDecodeCount;
            } else {
                lastTwoDecodeCount = 0;
            }
            lastDecodeCount = newLastDecodeCount;
        }
        return lastDecodeCount + lastTwoDecodeCount;
    }
}
