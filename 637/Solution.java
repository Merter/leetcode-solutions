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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> averageOfLevels = new ArrayList<>();
        if (root == null) {
            return averageOfLevels;
        }
        Deque<TreeNode> currentLevelNodeQueue = new ArrayDeque<>();
        Deque<TreeNode> nextLevelNodeQueue = new ArrayDeque<>();
        currentLevelNodeQueue.addLast(root);
        double currentLevelNodeValueSum = 0;
        int currentLevelNodeCount = 0;
        while (!currentLevelNodeQueue.isEmpty()) {
            TreeNode node = currentLevelNodeQueue.removeFirst();
            currentLevelNodeValueSum += node.val;
            currentLevelNodeCount++;
            if (node.left != null) {
                nextLevelNodeQueue.addLast(node.left);
            }
            if (node.right != null) {
                nextLevelNodeQueue.addLast(node.right);
            }
            if (currentLevelNodeQueue.isEmpty()) {
                averageOfLevels.add(currentLevelNodeValueSum / currentLevelNodeCount);
                currentLevelNodeValueSum = 0;
                currentLevelNodeCount = 0;
                currentLevelNodeQueue = nextLevelNodeQueue;
                nextLevelNodeQueue = new ArrayDeque<>();
            }
        }
        return averageOfLevels;
    }
}
