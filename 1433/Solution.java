class Solution {
    public boolean checkIfCanBreak(String s1, String s2) {
        String sortedS1 = sortedLetters(s1);
        String sortedS2 = sortedLetters(s2);
        int i = 0;
        while ((i<sortedS1.length()) && (sortedS1.charAt(i) == sortedS2.charAt(i))) {
            i++;
        }
        if (i==sortedS1.length()) {
            return true;
        }
        String smallSorted = sortedS1.charAt(i) < sortedS2.charAt(i) ? sortedS1 : sortedS2;
        String bigSorted = smallSorted.equals(sortedS1) ? sortedS2 : sortedS1;
        i++;
        while (i<smallSorted.length()) {
            if (smallSorted.charAt(i) > bigSorted.charAt(i)) {
                return false;
            }
            i++;
        }
        return true;
    }
    
    private String sortedLetters(String string) {
        char[] chars = string.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    private String sortedLettersComplex(String string) {
        Map<Character, Integer> char2Count = new HashMap<>();
        for (int i=0; i<string.length(); i++) {
            Character character = string.charAt(i);
            Integer count = char2Count.get(character);
            if (count == null) {
                count = 0;
            }
            char2Count.put(character, ++count);
        }
        StringBuilder stb = new StringBuilder();
        for (char character='a'; character<='z'; character++) {
            Integer count = char2Count.get(character);
            if (count == null) {
                continue;
            }
            for (int i=0; i<count; i++) {
                stb.append(character);
            }
        }
        return stb.toString();
    }
}