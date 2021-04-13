/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode inorderSuccessor(final TreeNode root, final TreeNode target) {
        return inOrderSuccessorWithAncestor(root, null, target);
    }
    
    private TreeNode inOrderSuccessorWithAncestor(
        final TreeNode node, final TreeNode nextAncestor, final TreeNode target) {
        if (node == target) {            
            return (target.right == null) ? nextAncestor : leftmostChild(target.right);
        }
        if (node.val > target.val) {
            return inOrderSuccessorWithAncestor(node.left, node, target);
        }
        return inOrderSuccessorWithAncestor(node.right, nextAncestor, target);
    }
    
    private TreeNode leftmostChild(final TreeNode node) {
        if (node.left == null) {
            return node;
        }
        return leftmostChild(node.left);
    }
}
