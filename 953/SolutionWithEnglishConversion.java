class SolutionWithEnglishConversion {
  public boolean isAlienSorted(String[] words, String order) {
    if (words.length < 2) {
      return true;
    }
    final Map<Character, Character> alien2English = new HashMap<>();
    for (int i=0; i<order.length(); i++) {
      alien2English.put(order.charAt(i), (char)('a'+i));
    }
    final String[] wordsInEnglish = new String[words.length];
    for (int i=0; i<words.length; i++) {
      wordsInEnglish[i] = convertFromAlienToEnglish(words[i], alien2English);
    }
    for (int i=1; i<wordsInEnglish.length; i++) {
      if (wordsInEnglish[i-1].compareTo(wordsInEnglish[i]) > 0) {
        return false;
      }
    }
    return true;
  }
  
  private String convertFromAlienToEnglish(final String word, final Map<Character, Character> alien2English) {
    final StringBuilder stb = new StringBuilder();
    for (int i=0; i<word.length(); i++) {
      stb.append(alien2English.get(word.charAt(i)));
    }
    return stb.toString();
  }
}