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
    
    private int mTiltSum;
    
    public int findTilt(TreeNode root) {
        sumTree(root);
        return mTiltSum;
    }
    
    private int sumTree(TreeNode node) {
        if (node == null) return 0;
        int leftSum = sumTree(node.left);
        int rightSum = sumTree(node.right);
        mTiltSum += Math.abs(leftSum-rightSum);
        return leftSum+rightSum+node.val;        
    }
}
