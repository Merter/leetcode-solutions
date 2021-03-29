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
    public String tree2str(final TreeNode root) {
        if (root == null) {
            return "";
        }
        final StringBuilder stb = new StringBuilder();
        addToStringBuilder(root, stb);
        return stb.toString();
    }
    
    private void addToStringBuilder(final TreeNode node, final StringBuilder stb) {
        stb.append(node.val);
        if (node.left != null) {
            stb.append("(");
            addToStringBuilder(node.left, stb);
            stb.append(")");
        }
        if (node.right != null) {
            if (node.left == null) {
                stb.append("()");
            }
            stb.append("(");
            addToStringBuilder(node.right, stb);
            stb.append(")");
        }
    }
}