class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> hasKeys = new HashSet<>();
        Deque<Integer> keyQueue = new ArrayDeque<>();
        keyQueue.add(0);
        while (!keyQueue.isEmpty()) {
            int currentRoom = keyQueue.removeFirst();
            hasKeys.add(currentRoom);
            List<Integer> foundKeys = rooms.get(currentRoom);
            for (int key : foundKeys) {
                if (hasKeys.contains(key)) {
                    continue;
                }
                hasKeys.add(key);
                keyQueue.addLast(key);
            }
        }
        return rooms.size() == hasKeys.size();
    }
}
