class Solution {
    public int maxPower(String s) {
        int maxPower = 1;
        int currentPower = 1;
        for (int i=1; i<s.length(); i++) {
            if (s.charAt(i-1) == s.charAt(i)) {
                currentPower++;
            } else {
                if (currentPower > maxPower) {
                    maxPower = currentPower;
                }
                currentPower = 1;
            }            
        }
        if (currentPower > maxPower) {
            maxPower = currentPower;
        }        
        return maxPower;
    }
}
