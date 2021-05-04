class Solution {
    public boolean isBipartite(int[][] graph) {
        final boolean[] bipartiteGroup = new boolean[graph.length];
        final Set<Integer> visited = new HashSet<>();
        Deque<Integer> queue = new ArrayDeque<>();
        Deque<Integer> childQueue = new ArrayDeque<>();
        Set<Integer> childSet = new HashSet<>();
        boolean group = true;
        for (int nodeIndex=0; nodeIndex<graph.length; nodeIndex++) {
            if (visited.contains(nodeIndex)) {
                continue;
            }
            queue.addLast(nodeIndex);
            while (! queue.isEmpty()) {
                final int node = queue.removeFirst();
                if (visited.contains(node)) {
                    if (bipartiteGroup[node] != group) {
                        return false;
                    }
                    continue;
                }
                visited.add(node);
                bipartiteGroup[node] = group;
                for (int i=0; i<graph[node].length; i++) {
                    final int neigh = graph[node][i];
                    if (visited.contains(neigh)) {
                        if (bipartiteGroup[neigh] == group) {
                            return false;
                        }
                        continue;
                    }
                    if (! childSet.contains(neigh)) {
                        childQueue.addLast(neigh);
                        childSet.add(neigh);
                    }
                }
                if (queue.isEmpty()) {
                    queue = childQueue;
                    childQueue = new ArrayDeque<>();
                    childSet = new HashSet<>();
                    group = !group;
                }
            }
        }
        return true;
    }
}
