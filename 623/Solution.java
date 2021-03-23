/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            return new TreeNode(val, root, null);
        }
        Deque<TreeNode> parentNodes = new ArrayDeque<>();
        Deque<TreeNode> childNodes = new ArrayDeque<>();
        int currentDepth = 0;
        parentNodes.addLast(root);
        while (currentDepth < depth-2) {
            final TreeNode currentNode = parentNodes.removeFirst();
            if (currentNode.left != null) {
                childNodes.addLast(currentNode.left);
            }
            if (currentNode.right != null) {
                childNodes.addLast(currentNode.right);
            }
            if (parentNodes.isEmpty()) {
                parentNodes = childNodes;
                childNodes = new ArrayDeque<>();
                currentDepth++;
            }
        }
        for (final TreeNode currentNode : parentNodes) {
            final TreeNode newLeftChild = new TreeNode(val, currentNode.left, null);
            currentNode.left = newLeftChild;
            final TreeNode newRightChild = new TreeNode(val, null, currentNode.right);
            currentNode.right = newRightChild;
        }
        return root;
    }
}