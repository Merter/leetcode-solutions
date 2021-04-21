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
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        final Deque<TreeNode> stack = new ArrayDeque<>();
        stack.addLast(root);
        TreeNode prev = null;
        while (! stack.isEmpty()) {
            final TreeNode node = stack.removeLast();
            if (node.right != null) {
                stack.addLast(node.right);
            }
            if (node.left != null) {
                stack.addLast(node.left);
            }
            if (prev != null) {
                prev.left = null;
                prev.right = node;
            }
            prev = node;
        }
    }
}
