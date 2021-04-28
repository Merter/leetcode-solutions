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

class Solution {
    public Node cloneGraph(final Node node) {
        if (node == null) {
            return null;
        }
        final Map<Node, Node> oldNode2NewNode = new HashMap<>();
        Deque<Node> queue = new ArrayDeque<>();
        queue.addLast(node);
        Node newBegin = null;
        // first BFT to create all new nodes and map them to the old ones
        while (! queue.isEmpty()) {
            final Node curr = queue.removeFirst();
            final Node newNode = new Node(curr.val);
            oldNode2NewNode.put(curr, newNode);
            if (newBegin == null) {
                newBegin = newNode;
            }
            for (final Node neigh : curr.neighbors) {
                if (oldNode2NewNode.containsKey(neigh)) {
                    continue;
                }
                queue.addLast(neigh);
            }                
        }
        // second BFT to populate the neighbors
        queue.addLast(node);
        while (! queue.isEmpty()) {
            final Node curr = queue.removeFirst();
            final Node newCurr = oldNode2NewNode.get(curr);
            if (! newCurr.neighbors.isEmpty()) {
                // visited before
                continue;
            }
            for (final Node neigh : curr.neighbors) {
                newCurr.neighbors.add(oldNode2NewNode.get(neigh));
                queue.addLast(neigh);
            }
        }
        return newBegin;
    }
}
