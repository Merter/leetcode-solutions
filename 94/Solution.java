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
    
    public List<Integer> inorderTraversal(TreeNode root) {
        return inorderTraversalByIteration(root);
    }
    
    private List<Integer> inorderTraversalByRecursion(TreeNode root) {
        List<Integer> traversal = new ArrayList<>();
        inorderTraversal(root, traversal);
        return traversal;
    }
    
    private void inorderTraversal(TreeNode node, List<Integer> traversal) {
        if (node == null) {
            return;
        }
        inorderTraversal(node.left, traversal);
        traversal.add(node.val);
        inorderTraversal(node.right, traversal);
    }
    
    private List<Integer> inorderTraversalByIteration(TreeNode root) {
        List<Integer> traversal = new ArrayList<>();
        TreeNode current = root;
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (current!=null || ! stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            traversal.add(current.val);
            current = current.right;
        }
        return traversal;
    }
}
