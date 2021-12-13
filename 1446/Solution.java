class Solution {
    public int maxPower(String s) {
        int maxPower = 1;
        int currPower = 1;
        for (int i=1; i<s.length(); i++) {
            if (s.charAt(i) == s.charAt(i-1)) {
                currPower++;
            } else {
                maxPower = Math.max(maxPower, currPower);
                currPower = 1;
            }
        }
        return Math.max(maxPower, currPower);
    }
}
