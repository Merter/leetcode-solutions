/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> preorder(final Node root) {
        final List<Integer> preOrderTraversal = new ArrayList<>();
        preorder(root, preOrderTraversal);
        return preOrderTraversal;
    }
    
    private void preorder(final Node node, final List<Integer> preOrderTraversal) {
        if (node == null) {
            return;
        }
        preOrderTraversal.add(node.val);
        for (final Node child : node.children) {
            preorder(child, preOrderTraversal);
        }
    }
}
