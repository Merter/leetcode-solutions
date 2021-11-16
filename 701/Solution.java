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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            TreeNode newRoot = new TreeNode(val);
            return newRoot;
        }
        insertIntoBSTWithParent(root, val);
        return root;
    }
    
    private void insertIntoBSTWithParent(TreeNode parent, int val) {
        if (val < parent.val) {
            if (parent.left == null) {
                TreeNode node = new TreeNode(val);
                parent.left = node;
                return;
            }
            insertIntoBSTWithParent(parent.left, val);
            return;
        }
        if (parent.right == null) {
            TreeNode node = new TreeNode(val);
            parent.right = node;
            return;
        }
        insertIntoBSTWithParent(parent.right, val);
        return;
    }
}
