class Solution {
    public List<String> letterCasePermutation(String s) {
        List<StringBuilder> permBuilders = new ArrayList<>();
        permBuilders.add(new StringBuilder());
        for (int i=0; i<s.length(); i++) {
            char chr = s.charAt(i);
            if (chr-'A' < 0) {  // chr is a digit
                for (StringBuilder stb : permBuilders) {
                    stb.append(chr);
                }
            } else {
                char[] caseChars = new char[2];
                if (chr-'a' < 0) {  // chr is uppercase
                    caseChars[0] = (char)(chr+('a'-'A'));
                    caseChars[1] = chr;
                } else {
                    caseChars[0] = chr;
                    caseChars[1] = (char)(chr-('a'-'A'));
                }
                List<StringBuilder> auxBuilders = new ArrayList<>();
                for (int charIndex=0; charIndex<caseChars.length; charIndex++) {
                    for (StringBuilder stb : permBuilders) {
                        StringBuilder newStb = new StringBuilder(stb);
                        newStb.append(caseChars[charIndex]);
                        auxBuilders.add(newStb);
                    }
                }
                permBuilders = auxBuilders;                
            }
        }
        List<String> perms = new ArrayList<>();
        for (StringBuilder stb : permBuilders) {
            perms.add(stb.toString());
        }
        return perms;
    }
}
