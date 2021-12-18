class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>(numCourses);
        for (int i=0; i<numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] prereq : prerequisites) {
            graph.get(prereq[0]).add(prereq[1]);
        }
        boolean[] visited = new boolean[numCourses];
        for (int i=0; i<numCourses; i++) {
            if (visited[i]) {
                continue;
            }            
            Set<Integer> path = new HashSet<>();
            path.add(i);
            if (! canFinish(graph, i, visited, path)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean canFinish(List<List<Integer>> graph, int node, boolean[] visited, Set<Integer> path) {
        visited[node] = true;
        for (int neigh : graph.get(node)) {
            if (path.contains(neigh)) {
                return false;
            }
            if (visited[neigh]) {
                continue;
            }
            path.add(neigh);
            if (! canFinish(graph, neigh, visited, path)) {
                return false;
            }
            path.remove(neigh);
        }
        return true;        
    }
}
