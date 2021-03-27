class SortedCharsAsKeySolution {
    public List<List<String>> groupAnagrams(String[] strs) {
        final Map<String, List<String>> canonicalForm2Items = new HashMap<>();
        for (final String str : strs) {
            final String canonicalForm = sortedCharsInString(str);
            List<String> items = canonicalForm2Items.get(canonicalForm);
            if (items == null) {
                items = new ArrayList();
                canonicalForm2Items.put(canonicalForm, items);
            }
            items.add(str);
        }
        final List<List<String>> groupedAnagrams = new ArrayList<>();
        for (final List<String> anagrams : canonicalForm2Items.values()) {
            groupedAnagrams.add(anagrams);
        }
        return groupedAnagrams;
    }
    
    private String sortedCharsInString(final String str) {
        final char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}