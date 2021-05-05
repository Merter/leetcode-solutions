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
    public TreeNode lowestCommonAncestor(final TreeNode root, final TreeNode p, final TreeNode q) {
        return lca(root, p, q);
    }
    
    private TreeNode lca(final TreeNode node, final TreeNode p, final TreeNode q) {
        if (node == null) {
            return null;
        }
        if (node==p || node==q) {
            return node;
        }
        boolean pInLeft = inTree(node.left, p);
        if (pInLeft) {
            if (inTree(node.left, q)) {
                return lca(node.left, p, q);
            }
            return node;
        }
        // p is on the right
        if (inTree(node.right, q))
        {
            return lca(node.right, p, q);
        }
        return node;
    }
    
    private boolean inTree(final TreeNode node, final TreeNode target) {
        if (node == null) {
            return false;
        }
        if (node == target) {
            return true;
        }
        if (inTree(node.left, target)) {
            return true;
        }
        return inTree(node.right, target);
    }
}
