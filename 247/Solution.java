class Solution {
    
    private static final Map<Character, Character> STROBOGRAMMATIC_DIGITS = new HashMap<>();
    static {
        STROBOGRAMMATIC_DIGITS.put('0', '0');
        STROBOGRAMMATIC_DIGITS.put('1', '1');
        STROBOGRAMMATIC_DIGITS.put('6', '9');
        STROBOGRAMMATIC_DIGITS.put('8', '8');
        STROBOGRAMMATIC_DIGITS.put('9', '6');
    }
        
    public List<String> findStrobogrammatic(final int n) {
        final List<String> strobogrammaticNumbers = recurseStrobogrammatic(n);
        if (n == 1) {
            return strobogrammaticNumbers;
        }
        return strobogrammaticNumbers
            .stream()
            .filter(num -> num.charAt(0) != '0')
            .collect(Collectors.toList());
    }
    
    private List<String> recurseStrobogrammatic(final int n) {
        final List<String> strobogrammaticNumbers = new ArrayList<>();
        if (n == 0) {
            strobogrammaticNumbers.add("");
            return strobogrammaticNumbers;
        }
        if (n == 1) {
            strobogrammaticNumbers.add("0");
            strobogrammaticNumbers.add("1");
            strobogrammaticNumbers.add("8");
            return strobogrammaticNumbers;
        }
        final List<String> sublist = recurseStrobogrammatic(n-2);
        for (final String substring : sublist) {
            for (final Map.Entry<Character, Character> entry : STROBOGRAMMATIC_DIGITS.entrySet()) {
                final StringBuilder stb = new StringBuilder();
                stb.append(entry.getKey());
                stb.append(substring);
                stb.append(entry.getValue());
                strobogrammaticNumbers.add(stb.toString());
            }
        }
        return strobogrammaticNumbers;
    }
}
