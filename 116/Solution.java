/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Deque<Node> currentNodeLevel = new ArrayDeque<>();
        Deque<Node> nextNodeLevel = new ArrayDeque<>();
        currentNodeLevel.add(root);
        while (!currentNodeLevel.isEmpty()) {
            Node node = currentNodeLevel.removeFirst();
            if (node.left != null) {
                nextNodeLevel.add(node.left);
            }
            if (node.right != null) {
                nextNodeLevel.add(node.right);
            }
            if (!currentNodeLevel.isEmpty()) {
                node.next = currentNodeLevel.peekFirst();
            } else {
                currentNodeLevel = nextNodeLevel;
                nextNodeLevel = new ArrayDeque<>();
            }
        }
        return root;        
    }
}
