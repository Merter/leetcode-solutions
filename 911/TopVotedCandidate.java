class TopVotedCandidate {

    private int[] voteCounts;
    private TreeMap<Integer, Integer> time2Leader;
    
    public TopVotedCandidate(int[] persons, int[] times) {
        voteCounts = new int[persons.length];
        int maxVotedPerson = 0;
        time2Leader = new TreeMap<>();
        for (int i=0; i<times.length; i++) {
            int time = times[i];
            int votedPerson = persons[i];
            voteCounts[votedPerson]++;
            if (voteCounts[votedPerson] >= voteCounts[maxVotedPerson]) {
                maxVotedPerson = votedPerson;
            }
            time2Leader.put(time, maxVotedPerson);
        }
    }
    
    public int q(int t) {
        return time2Leader.floorEntry(t).getValue();
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */
