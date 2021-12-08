class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        LinkedList<Integer> idStack = new LinkedList<>();
        int[] durations = new int[n];
        int prevStartTime = 0;
        for (String log : logs) {
            String[] parts = log.split(":");
            int id = Integer.parseInt(parts[0]);
            String action = parts[1];
            int time = Integer.parseInt(parts[2]);
            if ("start".equals(action)) {
                if (! idStack.isEmpty()) {
                    durations[idStack.peek()] += time-prevStartTime;
                }
                idStack.push(id);
                prevStartTime = time;
            } else {    // action is "end"
                int endTime = time+1;
                durations[id] += endTime-prevStartTime;
                idStack.pop();
                prevStartTime = endTime;
            }         
        }
        return durations;
    }
}
