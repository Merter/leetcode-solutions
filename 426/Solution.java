/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
    public Node treeToDoublyList(final Node root) {
        if (root == null) {
            return null;
        }
        final Node leftChild = root.left;
        final Node rightChild = root.right;
        Node leftBegin = treeToDoublyList(leftChild);
        if (leftBegin != null) {
            final Node leftEnd = leftBegin.left;
            leftBegin.left = root;
            root.left = leftEnd;
            root.right = leftBegin;
            leftEnd.right = root;
        } else {
            // first item
            root.left = root;
            root.right = root;
            leftBegin = root;
        }
        Node rightBegin = treeToDoublyList(rightChild);
        if (rightBegin != null) {
            final Node rightEnd = rightBegin.left;
            rightBegin.left = root;
            root.right = rightBegin;
            leftBegin.left = rightEnd;            
            rightEnd.right = leftBegin;
        }
        return leftBegin;
    }
}
