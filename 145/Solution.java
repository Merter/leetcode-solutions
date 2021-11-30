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
    
    public List<Integer> postorderTraversal(TreeNode root) {
        return postorderTraversalByIteration(root);
    }
    
    private List<Integer> postorderTraversalByIteration(TreeNode root) {
        List<Integer> traversal = new ArrayList<>();
        if (root == null) {
            return traversal;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.addLast(root);
        while (! stack.isEmpty()) {
            TreeNode node = stack.pop();
            traversal.addFirst(node.val);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        return traversal;
    }

    private List<Integer> postorderTraversalByRecursion(TreeNode root) {
        List<Integer> traversal = new ArrayList<>();
        postorderTraversal(root, traversal);
        return traversal;
    }
    
    private void postorderTraversal(TreeNode node, List<Integer> traversal) {
        if (node == null) {
            return;
        }
        postorderTraversal(node.left, traversal);
        postorderTraversal(node.right, traversal);
        traversal.add(node.val);
    }
}