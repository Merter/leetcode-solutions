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
    
    Map<TreeNode, Integer> node2Height = new HashMap<>();
    
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        calculateHeight(root);
        return findSubtreeWithAllDeepest(root);
    }
    
    private void calculateHeight(TreeNode node) {
        TreeNode leftNode = node.left;
        int leftHeight = -1;
        if (leftNode != null) {
            calculateHeight(leftNode);
            leftHeight = node2Height.get(leftNode);
        }
        TreeNode rightNode = node.right;
        int rightHeight = -1;
        if (rightNode != null) {
            calculateHeight(rightNode);
            rightHeight = node2Height.get(rightNode);
        }
        node2Height.put(node, Math.max(leftHeight, rightHeight) + 1);
    }
    
    private TreeNode findSubtreeWithAllDeepest(TreeNode node) {
        TreeNode leftNode = node.left;
        int leftHeight = -1;
        if (leftNode != null) {
            leftHeight = node2Height.get(leftNode);
        }        
        TreeNode rightNode = node.right;
        int rightHeight = -1;
        if (rightNode != null) {
            rightHeight = node2Height.get(rightNode);
        }
        if (leftHeight == rightHeight) {
            return node;
        }
        if (leftHeight > rightHeight) {
            return findSubtreeWithAllDeepest(leftNode);
        }
        return findSubtreeWithAllDeepest(rightNode);
    }
}
