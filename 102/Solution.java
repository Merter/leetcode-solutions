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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelOrder = new ArrayList<>();
        List<Integer> currentLevelValues = new ArrayList<>();
        if (root == null) {
            return levelOrder;
        }
        Deque<TreeNode> currentLevelNodeQueue = new ArrayDeque<>();
        Deque<TreeNode> nextLevelNodeQueue = new ArrayDeque<>();
        currentLevelNodeQueue.addLast(root);
        while (!currentLevelNodeQueue.isEmpty()) {
            TreeNode node = currentLevelNodeQueue.removeFirst();
            currentLevelValues.add(node.val);
            if (node.left != null) {
                nextLevelNodeQueue.addLast(node.left);
            }
            if (node.right != null) {
                nextLevelNodeQueue.addLast(node.right);
            }
            if (currentLevelNodeQueue.isEmpty()) {
                levelOrder.add(currentLevelValues);
                currentLevelValues = new ArrayList<>();
                currentLevelNodeQueue = nextLevelNodeQueue;
                nextLevelNodeQueue = new ArrayDeque<>();
            }
        }
        return levelOrder;
    }
}