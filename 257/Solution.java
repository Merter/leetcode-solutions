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
    public List<String> binaryTreePaths(TreeNode root) {
        final List<String> paths = new ArrayList<>();
        dfs(root, paths, String.format("%d", root.val));
        return paths;
    }
    
    private void dfs(final TreeNode node, final List<String> paths, final String pathUpToNode) {
        if (node.left == null) {
            if (node.right == null) {
                paths.add(pathUpToNode);
                return;
            }
            dfs(node.right, paths, String.format("%s->%d", pathUpToNode, node.right.val));
            return;
        }
        dfs(node.left, paths, String.format("%s->%d", pathUpToNode, node.left.val));
        if (node.right != null) {
            dfs(node.right, paths, String.format("%s->%d", pathUpToNode, node.right.val));
        }
    }
}
