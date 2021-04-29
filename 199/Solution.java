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
    public List<Integer> rightSideView(final TreeNode root) {
        final List<Integer> rightSideNodes = new ArrayList<>();
        if (root == null) {
            return rightSideNodes;
        }
        Deque<TreeNode> parentQueue = new ArrayDeque<>();
        Deque<TreeNode> childQueue = new ArrayDeque<>();
        parentQueue.addLast(root);
        while (! parentQueue.isEmpty()) {
            final TreeNode node = parentQueue.removeFirst();
            if (node.left != null) {
                childQueue.addLast(node.left);
            }
            if (node.right != null) {
                childQueue.addLast(node.right);
            }
            if (parentQueue.isEmpty()) {
                // rightmost node in that level
                rightSideNodes.add(node.val);
                parentQueue = childQueue;
                childQueue = new ArrayDeque<>();
            }
        }
        return rightSideNodes;
    }
}
