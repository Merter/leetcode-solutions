class StreamChecker {
    
    Map<Character, Trie> char2Trie = new HashMap<>();
    ArrayList<Character> chars = new ArrayList<>();
    
    private static class Trie {
        boolean wordBegin;
        Map<Character, Trie> char2Trie = new HashMap<>();
    }
    
    public StreamChecker(String[] words) {
        for (String word : words) {
            addWordToTrie(word);
        }
    }
    
    private void addWordToTrie(String word) {
        Map<Character, Trie> currentChar2Trie = char2Trie;
        for (int i=word.length()-1; i>0; i--) {
            char chr = word.charAt(i);
            Trie trie = currentChar2Trie.get(chr);
            if (trie == null) {
                trie = new Trie();
                currentChar2Trie.put(chr, trie);
            }
            currentChar2Trie = trie.char2Trie;
        }
        // add the first char with wordBegin
        Trie trie = currentChar2Trie.get(word.charAt(0));
        if (trie == null) {
            trie = new Trie();
            currentChar2Trie.put(word.charAt(0), trie);
        }
        trie.wordBegin = true;
    }
    
    public boolean query(char letter) {
        chars.add(letter);
        Map<Character, Trie> currentChar2Trie = char2Trie;
        for (int i=chars.size()-1; i>=0 ; i--) {
            Trie trie = currentChar2Trie.get(chars.get(i));
            if (trie == null) {
                return false;
            }
            if (trie.wordBegin) {
                return true;
            }
            currentChar2Trie = trie.char2Trie;
        }
        return false;
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */
 