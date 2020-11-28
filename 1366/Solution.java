class Solution {
    
    private static class Team implements Comparable<Team> {        
        String mLetter;
        int[] mPositionCount;
        
        Team(String letter, int totalCount) {
            mLetter = letter;
            mPositionCount = new int[totalCount];
        }
        
        public int compareTo(Team otherTeam) {
            if (this==otherTeam || this.mLetter==otherTeam.mLetter) {
                return 0;
            }
            for (int i=0; i<mPositionCount.length; i++) {
                if (this.mPositionCount[i] > otherTeam.mPositionCount[i]) {
                    return -1;
                }
                if (this.mPositionCount[i] < otherTeam.mPositionCount[i]) {
                    return 1;
                }
            }
            return mLetter.compareTo(otherTeam.mLetter);
        }
    }
    
    public String rankTeams(String[] votes) {
        String firstVote = votes[0];
        int totalCount = firstVote.length();
        ArrayList<Team> teams = new ArrayList<>(totalCount);
        Map<String, Team> letter2Team = new HashMap<>();
        for (int i=0; i<totalCount; i++) {
            String letter = String.valueOf(firstVote.charAt(i));
            Team team = new Team(letter, totalCount);
            teams.add(team);
            letter2Team.put(letter, team);
        }
        for (String vote : votes) {
            for (int i=0; i<vote.length(); i++) {
                Team votedTeam = letter2Team.get(String.valueOf(vote.charAt(i)));
                votedTeam.mPositionCount[i]++;
            }
        }
        Collections.sort(teams);
        StringBuilder stb = new StringBuilder();
        for (Team team : teams) {
            stb.append(team.mLetter);
        }
        return stb.toString();
    }
}
