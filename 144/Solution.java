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
    
    public List<Integer> preorderTraversal(TreeNode root) {
        return preorderTraversalByIteration(root);
    }
    
    private List<Integer> preorderTraversalByIteration(TreeNode root) {
        List<Integer> traversal = new ArrayList<>();
        if (root == null) {
            return traversal;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (! stack.isEmpty()) {
            TreeNode node = stack.pop();
            traversal.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return traversal;
    }
    
    private List<Integer> preorderTraversalByRecursion(TreeNode root) {
        final List<Integer> traversal = new ArrayList<>();
        preorderTraversal(root, traversal);
        return traversal;
    }
    
    private void preorderTraversal(TreeNode node, List<Integer> traversal) {
        if (node == null) {
            return;
        }
        traversal.add(node.val);
        preorderTraversal(node.left, traversal);
        preorderTraversal(node.right, traversal);
    }
}