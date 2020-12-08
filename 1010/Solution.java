class Solution {
    public int numPairsDivisibleBy60(int[] durations) {
        Map<Integer, Integer> canonicalDuration2Count = new HashMap<>();
        for (int duration : durations) {
            int canonicalDuration = duration%60;
            Integer count = canonicalDuration2Count.get(canonicalDuration);
            if (count == null) { 
                count = 0;
            }
            canonicalDuration2Count.put(canonicalDuration, ++count);
        }
        int numPairs = 0;
        for (Map.Entry<Integer, Integer> canonicalDurationAndCount : canonicalDuration2Count.entrySet()) {
            int canonicalDuration = canonicalDurationAndCount.getKey();
            if (canonicalDuration > 30) {
                continue;
            }
            int count = canonicalDurationAndCount.getValue();
            if (canonicalDuration==0 || canonicalDuration==30) {
                if (count > 1) {
                    numPairs += (count*(count-1)) / 2;                    
                }
            } else {
                int targetCanonicalDuration = 60 - canonicalDuration;
                Integer targetCount = canonicalDuration2Count.get(targetCanonicalDuration);
                if (targetCount == null) {
                    continue;
                }
                numPairs += count*targetCount;
            }
        }
        return numPairs;      
    }
}
