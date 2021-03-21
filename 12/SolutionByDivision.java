class SolutionByDivision {
    
    private static final Map<Integer, String> TENS = new HashMap<>();
    private static final Map<Integer, String> FIVES = new HashMap<>();
    static {
        TENS.put(1000, "M");
        TENS.put(100, "C");
        TENS.put(10, "X");
        TENS.put(1, "I");
        FIVES.put(100, "D");
        FIVES.put(10, "L");
        FIVES.put(1, "V");
    }
    
    public String intToRoman(final int num) {
        final StringBuilder stb = new StringBuilder();
        appendPowerOfTen(num, 1000, stb);
        final int numWithoutThousands = num % 1000;
        appendPowerOfTen(numWithoutThousands, 100, stb);
        final int numWithoutHundreds = num % 100;
        appendPowerOfTen(numWithoutHundreds, 10, stb);
        final int numWithoutTens = num % 10;
        appendPowerOfTen(numWithoutTens, 1, stb);        
        return stb.toString();
    }
        
    private void appendPowerOfTen(final int num, final int powerOfTen, final StringBuilder stb) {
        int quotient = num / powerOfTen;
        if (quotient == 0) {
            return;
        }
        if (quotient < 4) {
            for (int i=0; i<quotient; i++) {
                stb.append(TENS.get(powerOfTen));
            }
            return;
        }
        if (quotient == 4) {
            stb.append(TENS.get(powerOfTen));
            stb.append(FIVES.get(powerOfTen));
            return;
        }
        if (quotient == 9) {
            stb.append(TENS.get(powerOfTen));
            stb.append(TENS.get(powerOfTen*10));
            return;
        }
        stb.append(FIVES.get(powerOfTen));
        for (int i=0; i<quotient-5; i++) {
            stb.append(TENS.get(powerOfTen));
        }
    }    
    
}