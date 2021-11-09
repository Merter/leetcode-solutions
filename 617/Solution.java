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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            if (root2 == null) {
                return null;
            }
            TreeNode mergedTree = new TreeNode(root2.val);
            mergedTree.right = mergeTrees(null, root2.right);
            mergedTree.left = mergeTrees(null, root2.left);
            return mergedTree;
        }
        if (root2 == null) {
            TreeNode mergedTree = new TreeNode(root1.val);
            mergedTree.right = mergeTrees(root1.right, null);
            mergedTree.left = mergeTrees(root1.left, null);
            return mergedTree;
        }
        TreeNode mergedTree = new TreeNode(root1.val + root2.val);
        mergedTree.right = mergeTrees(root1.right, root2.right);
        mergedTree.left = mergeTrees(root1.left, root2.left);
        return mergedTree;        
    }
}