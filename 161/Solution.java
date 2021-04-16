class Solution {
    public boolean isOneEditDistance(String str, String target) {
        if (Math.abs(str.length() - target.length()) > 1) {
            return false;
        }
        if (str.equals(target)) {
            return false;
        }
        if (str.length() == target.length()) {
            boolean differentFound = false;
            for (int i=0; i<str.length(); i++) {
                if (str.charAt(i) != target.charAt(i)) {
                    if (differentFound) {
                        return false;
                    }
                    differentFound = true;
                }
            }
            return true;
        }
        final String shorter = str.length()<target.length() ? str : target;
        final String longer = str.length()>target.length() ? str : target;
        boolean insertFound = false;
        for (int i=0; i<shorter.length(); i++) {
            if (insertFound){
                if (shorter.charAt(i) != longer.charAt(i+1)) {
                    return false;
                }
            } else {
                if (shorter.charAt(i) != longer.charAt(i)) {
                    insertFound = true;
                    i--;
                }
            }
        }
        return true;
    }
}
