class WordDictionary {

    private static class Trie {
        
        final char trieChar;
        Map<Character, Trie> trieChar2SucceedingChars = new HashMap<>();
        boolean isValidWord = false;
        
        public Trie(final char chr) {
            trieChar = chr; 
            trieChar2SucceedingChars.put(chr, null);
        }
        
        public void addWord(final String word) {
            addWordStartingFrom(word, 0);
        }
        
        public boolean search(final String word) {
            return searchStartingFrom(word, 0);
        }
        
        private void addWordStartingFrom(final String word, final int start) {            
            if (start == word.length()) {
                isValidWord = true;
                return;
            }
            final char startChar = word.charAt(start);
            Trie succeedingChars = trieChar2SucceedingChars.get(startChar);
            if (succeedingChars == null) {
                succeedingChars = new Trie(startChar);
                trieChar2SucceedingChars.put(startChar, succeedingChars);
            }
            succeedingChars.addWordStartingFrom(word, start+1);
        }

        private boolean searchStartingFrom(final String word, final int start) {
            if (start == word.length()) {
                return isValidWord;
            }
            final char searchStartChar = word.charAt(start);
            if ('.' == searchStartChar) {
                for (final Map.Entry<Character, Trie> entry : trieChar2SucceedingChars.entrySet()) {
                    if (entry.getValue() == null) {
                        continue;
                    }
                    final Trie trieToSearch = entry.getValue();
                    if (trieToSearch.searchStartingFrom(word, start+1)) {
                        return true;
                    }
                }
                return false;
            } else {
                Trie succeedingChars = trieChar2SucceedingChars.get(searchStartChar);
                if (succeedingChars == null) {
                    return false;
                }
                return succeedingChars.searchStartingFrom(word, start+1);
            }
        }        
    }
    
    final Trie trie = new Trie('$');
    
    public void addWord(final String word) {
        trie.addWord(word);
    }
    
    public boolean search(final String word) {
        return trie.search(word);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
 