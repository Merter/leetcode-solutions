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
    public boolean isValidBST(final TreeNode root) {
        return isValidBSTInRange(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean isValidBSTInRange(final TreeNode node, final long begin, final long end) {
        if (node == null) {
            return true;
        }
        if (node.val<=begin || node.val>=end) {
            return false;
        }
        return isValidBSTInRange(node.left, begin, node.val) 
            && isValidBSTInRange(node.right, node.val, end);
    }
}
