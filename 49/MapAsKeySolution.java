class MapAsKeySolution {
    public List<List<String>> groupAnagrams(final String[] strs) {
        final Map<Map<Character, Integer>, List<String>> canonicalChar2Count2Strs = new HashMap<>();
        for (final String str : strs) {
            final Map<Character, Integer> char2Count = char2Count(str);
            List<String> anagramStrs = canonicalChar2Count2Strs.get(char2Count);
            if (anagramStrs == null) {
                anagramStrs = new ArrayList<>();
                canonicalChar2Count2Strs.put(char2Count, anagramStrs);
            }
            anagramStrs.add(str);
        }
        final List<List<String>> anagramGroups = new ArrayList<>();
        for (final List<String> anagrams : canonicalChar2Count2Strs.values()) {
            anagramGroups.add(anagrams);
        }
        return anagramGroups;
    }
    
    private Map<Character, Integer> char2Count(final String str) {
        final Map<Character, Integer> char2Count = new HashMap<>();
        for (final char chr : str.toCharArray()) {
            Integer count = char2Count.get(chr);
            if (count == null) {
                count = 0;
            }
            char2Count.put(chr, count+1);
        }
        return char2Count;
    }
}