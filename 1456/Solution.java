class Solution {
    
    private static final Set<Character> VOWELS = Stream.of('a', 'e', 'i', 'o', 'u')
        .collect(Collectors.toCollection(HashSet::new));
    
    public int maxVowels(String s, int k) {
        int end = s.length()-k;
        int currentVowelCount = 0;
        for (int i=0; i<k; i++) {
            if (VOWELS.contains(s.charAt(i))) {
                currentVowelCount++;
            }
        }
        int maxVowelCount = currentVowelCount;
        for (int i=1; i<=end; i++) {
            if (VOWELS.contains(s.charAt(i-1))) {
                currentVowelCount--;
            }
            if (VOWELS.contains(s.charAt(i+k-1))) {
                currentVowelCount++;
            }
            if (currentVowelCount > maxVowelCount) {
                maxVowelCount = currentVowelCount;
            }
        }
        return maxVowelCount;
    }
}
