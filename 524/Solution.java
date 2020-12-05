class Solution {
    public String findLongestWord(String str, List<String> words) {
        String longestWord = "";
        if (words==null || words.size()==0 || str==null || str.equals(longestWord)) {
            return longestWord;
        }
        for (String word : words) {
            if (canBeConstructedByDeletionFrom(str, word)) {
                if (word.length() > longestWord.length()) {
                    longestWord = word;
                } else if (word.length()==longestWord.length() && word.compareTo(longestWord)<0) {
                    longestWord = word;
                }
            }
        }
        return longestWord;
    }    
        
    private boolean canBeConstructedByDeletionFrom(String template, String target) {
        int templateIndex = 0;
        int targetIndex = 0;
        while (targetIndex < target.length()) {
            if (template.length()-templateIndex < target.length()-targetIndex ) {
                return false;
            }
            if (template.charAt(templateIndex) == target.charAt(targetIndex)) {
                targetIndex++;
            }
            templateIndex++;
        }
        return true;
    }
}
