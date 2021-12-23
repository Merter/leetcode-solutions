/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class SolutionWithDfs {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Map<Node, Node> oldNode2NewNode = new HashMap<>();
        dfs(node, oldNode2NewNode);
        return oldNode2NewNode.get(node);
    }
    
    private void dfs(Node node, Map<Node, Node> oldNode2NewNode) {
        Node newNode = new Node(node.val);
        oldNode2NewNode.put(node, newNode);
        for (Node neighbor : node.neighbors) {
            Node newNeighbor = oldNode2NewNode.get(neighbor);
            if (newNeighbor != null) {
                newNode.neighbors.add(newNeighbor);
            } else {
                dfs(neighbor, oldNode2NewNode);
                newNode.neighbors.add(oldNode2NewNode.get(neighbor));
            }
        }        
    }
}
