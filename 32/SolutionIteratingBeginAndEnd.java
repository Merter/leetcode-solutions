class SolutionIteratingBeginAndEnd {
    public int longestValidParentheses(String s) {
        int maxLength = 0;
        int beginIndex = 0;
        while (beginIndex < s.length()-1) {
            if (s.charAt(beginIndex++) == ')') {
                continue;
            }
            int openCount = 1;
            int endIndex = beginIndex;
            while (endIndex < s.length()) {
                if (s.charAt(endIndex++) == '(') {
                    openCount++;
                    continue;
                }
                openCount--;
                if (openCount == 0) {
                    maxLength = Math.max(maxLength, endIndex-beginIndex+1);
                }
                if (openCount < 0) {
                    break;
                }
            }            
        }
        return maxLength;
    }
}
