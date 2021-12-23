class Solution {
    
    public class UnionFind {
        
        private int[] parent;
        private int[] rank;
        
        public int numFinds;
        
        public UnionFind(int size) {
            numFinds = size;
            parent = new int[size];
            rank = new int[size];
            for (int i=0; i<size; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }
        
        private int find(int node) {
            if (parent[node] == node) {
                return node;
            }
            return parent[node] = find(parent[node]);
        }
        
        public void union(int thisNode, int thatNode) {
            int thisFind = find(thisNode);
            int thatFind = find(thatNode);
            if (thisFind == thatFind) {
                return;
            }
            numFinds--;
            if (rank[thisFind] > rank[thatFind]) {
                parent[thatFind] = thisFind;
            } else if (rank[thatFind] > rank[thisFind]) {
                parent[thisFind] = thatFind;
            } else {
                parent[thisFind] = thatFind;
                rank[thisFind]++;
            }
        }
    }
    
    public int earliestAcq(int[][] logs, int n) {
        Arrays.sort(logs, new Comparator<int[]>() {
            public int compare(int[] thisLog, int[] thatLog) {
                return thisLog[0]-thatLog[0];
            }
        });
        UnionFind unionFind = new UnionFind(n);
        for (int[] log : logs) {
            unionFind.union(log[1], log[2]);
            if (unionFind.numFinds == 1) {
                return log[0];
            }
        }
        return -1;        
    }
}
