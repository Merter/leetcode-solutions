class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> allPathsSourceTarget = new ArrayList<>();
        int[] neighborsOfSource = graph[0];
        LinkedList<Integer> path = new LinkedList<>();
        path.addLast(0);
        for (int neighbor : neighborsOfSource) {
            dfs(graph, neighbor, path, allPathsSourceTarget);
        }
        return allPathsSourceTarget;
    }
    
    private void dfs(
        int[][] graph, int source, LinkedList<Integer> path, List<List<Integer>> allPathsSourceTarget) {
        
        path.addLast(source);
        if (source == graph.length-1) {
            List<Integer> sourceToTargetPath = new ArrayList<>();
            sourceToTargetPath.addAll(path);
            allPathsSourceTarget.add(sourceToTargetPath);
        } else {
            int[] neighborsOfSource = graph[source];
            for (int neighbor : neighborsOfSource) {
                dfs(graph, neighbor, path, allPathsSourceTarget);
            }
        }
        path.removeLast();
    }
}
