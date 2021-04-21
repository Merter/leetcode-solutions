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
    public List<Integer> postorder(final Node root) {
        final List<Integer> postOrderTraversal = new ArrayList<>();
        postorder(root, postOrderTraversal);
        return postOrderTraversal;
    }
    
    private void postorder(final Node node, final List<Integer> postOrderTraversal) {
        if (node == null) {
            return;
        }
        for (final Node child : node.children) {
            postorder(child, postOrderTraversal);
        }
        postOrderTraversal.add(node.val);
    }
}
