public class CharByCharSolution {

    private static final List<Character> ROMAN_LITERALS_FOR_TEN = new ArrayList<Character>(4);
    static {
        ROMAN_LITERALS_FOR_TEN.add('I');
        ROMAN_LITERALS_FOR_TEN.add('X');
        ROMAN_LITERALS_FOR_TEN.add('C');
        ROMAN_LITERALS_FOR_TEN.add('M');
    }
    
    private static final List<Character> ROMAN_LITERALS_FOR_FIVE = new ArrayList<Character>(3);
    static {
        ROMAN_LITERALS_FOR_FIVE.add('V');
        ROMAN_LITERALS_FOR_FIVE.add('L');
        ROMAN_LITERALS_FOR_FIVE.add('D');
    }

    public String intToRoman(int num) {
        String numStr = Integer.toString(num);
        char[] content = numStr.toCharArray();
        int powerOfTen = content.length;
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<content.length; i++) {
            powerOfTen--;
            if (content[i] == '0')
                continue;
            if (content[i] == '4') {
                sb.append(ROMAN_LITERALS_FOR_TEN.get(powerOfTen));
                sb.append(ROMAN_LITERALS_FOR_FIVE.get(powerOfTen));
                continue;
            }
            if (content[i] == '9') {
                sb.append(ROMAN_LITERALS_FOR_TEN.get(powerOfTen));
                sb.append(ROMAN_LITERALS_FOR_TEN.get(powerOfTen+1));
                continue;
            }
            if (content[i]=='1' || content[i]=='2' || content[i]=='3') {
                for (char c='0'; c<content[i]; c++)
                    sb.append(ROMAN_LITERALS_FOR_TEN.get(powerOfTen));
                continue;
            }
            sb.append(ROMAN_LITERALS_FOR_FIVE.get(powerOfTen));
            for (char c='5'; c<content[i]; c++)
                sb.append(ROMAN_LITERALS_FOR_TEN.get(powerOfTen));
        }
        return sb.toString();
    }
}