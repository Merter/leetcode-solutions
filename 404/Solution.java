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
    public int sumOfLeftLeaves(TreeNode root) {
        return sumOfLeftLeaves(root, 0);
    }
    
    private int sumOfLeftLeaves(TreeNode node, int currentSumOfLeftLeaves) {
        if (node == null) {
            return currentSumOfLeftLeaves;
        }        
        if (node.left!=null && isLeaf(node.left)) {
            currentSumOfLeftLeaves = node.left.val + currentSumOfLeftLeaves;
            return sumOfLeftLeaves(node.right, currentSumOfLeftLeaves);
        }
        if (node.left != null) {
            currentSumOfLeftLeaves = sumOfLeftLeaves(node.left, currentSumOfLeftLeaves);
        }
        if (node.right != null) {
            currentSumOfLeftLeaves = sumOfLeftLeaves(node.right, currentSumOfLeftLeaves);
        }
        return currentSumOfLeftLeaves;
    }
    
    private boolean isLeaf(TreeNode node) {
        return node.left==null && node.right==null;
    }
}
