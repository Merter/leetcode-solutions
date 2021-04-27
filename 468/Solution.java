class Solution {
    
    private static final Set<Character> VALID_IP6_CHARS = new HashSet<>();
    static {
        VALID_IP6_CHARS.add('A');
        VALID_IP6_CHARS.add('a');
        VALID_IP6_CHARS.add('B');
        VALID_IP6_CHARS.add('b');
        VALID_IP6_CHARS.add('C');
        VALID_IP6_CHARS.add('c');
        VALID_IP6_CHARS.add('D');
        VALID_IP6_CHARS.add('d');
        VALID_IP6_CHARS.add('E');
        VALID_IP6_CHARS.add('e');
        VALID_IP6_CHARS.add('F');
        VALID_IP6_CHARS.add('f');
    }
    
    public String validIPAddress(final String ip) {
        if (isValidIp4(ip)) {
            return "IPv4";
        }
        if (isValidIp6(ip)) {
            return "IPv6";
        }
        return "Neither";
    }
    
    private boolean isValidIp4(final String ip) {
        final int ipLen = ip.length();
        if (ipLen<7 || ipLen>15) {
            return false;
        }
        StringBuilder stb = new StringBuilder();
        int separatorCount = 0;
        for (int i=0; i<ipLen; i++) {
            final char ipChar = ip.charAt(i);
            if (! Character.isDigit(ipChar) && ipChar!='.') {
                return false;
            }
            if (ipChar == '.') {
                if (separatorCount == 3) {
                    return false;
                }
                separatorCount++;
                if (! isValidIp4Value(stb.toString())) {
                    return false;
                }
                stb = new StringBuilder();
            } else {
                if (ipChar=='0' && stb.length()>0 && stb.charAt(stb.length()-1)=='0') {
                    // two consecutive zeros
                    return false;
                }
                if (stb.length() == 3) {
                    return false;
                }
                stb.append(ipChar);
                if (stb.charAt(0)=='0' && stb.length()>1) {
                    // leading zero
                    return false;
                }
            }
        }
        if (separatorCount != 3) {
            return false;
        }
        // check the last number
        return isValidIp4Value(stb.toString());
    }
    
    private boolean isValidIp4Value(final String ipValueAsString) {
        if (ipValueAsString.length() == 0){
            return false;
        }
        final int ipSubValue = Integer.parseInt(ipValueAsString);
        if (ipSubValue > 255) {
            return false;
        }
        return true;
    }
    
    private boolean isValidIp6(final String ip) {
        final int ipLen = ip.length();
        if (ipLen<15 || ipLen>39) {
            return false;
        }
        StringBuilder stb = new StringBuilder();
        int separatorCount = 0;
        for (int i=0; i<ipLen; i++) {
            final char ipChar = ip.charAt(i);
            if (! Character.isDigit(ipChar) && ipChar!=':' && ! VALID_IP6_CHARS.contains(ipChar)) {
                return false;
            }
            if (ipChar == ':') {
                if (separatorCount == 7) {
                    return false;
                }
                separatorCount++;
                if (stb.length() == 0) {
                    return false;
                }
                stb = new StringBuilder();
            } else {
                if (stb.length() == 4) {
                    return false;
                }
                stb.append(ipChar);
            }
        }
        if (separatorCount != 7) {
            return false;
        }
        // check the last number
        return stb.length() > 0;
    }
}
