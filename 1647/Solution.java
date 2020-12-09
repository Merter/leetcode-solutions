class Solution {
    public int minDeletions(String s) {
        Map<Character, Integer> letter2Frequency = new HashMap<>();
        for (int i=0; i<s.length(); i++) {
            char letter = s.charAt(i);
            Integer frequency = letter2Frequency.get(letter);
            if (frequency == null) {
                frequency = 0;
            }
            letter2Frequency.put(letter, ++frequency);
        }
        Map<Integer, Integer> frequency2LetterCount = new HashMap<>();
        Set<Integer> occupiedFrequencies = new HashSet<>();
        for (Map.Entry<Character, Integer> letterAndFrequency : letter2Frequency.entrySet()) {
            int frequency = letterAndFrequency.getValue();
            occupiedFrequencies.add(frequency);
            Integer letterCount = frequency2LetterCount.get(frequency);
            if (letterCount == null) {
                letterCount = 0;
            } 
            frequency2LetterCount.put(frequency, ++letterCount);
        }
        int numDeletions = 0;
        for (Map.Entry<Integer, Integer> frequencyAndLetterCount : frequency2LetterCount.entrySet()) {
            int frequency = frequencyAndLetterCount.getKey();
            int letterCount = frequencyAndLetterCount.getValue();
            if (letterCount == 1) {
                continue;
            }
            int currentLetterCount = letterCount-1;
            for (int i=frequency-1; i>0; i--) {
                if (!occupiedFrequencies.contains(i)) {
                    currentLetterCount--;                    
                    numDeletions += (frequency-i);
                    occupiedFrequencies.add(i);
                    if (currentLetterCount == 0) {
                        break;
                    }
                }
            }
            numDeletions += currentLetterCount*frequency;
        }
        return numDeletions;
    }
}
