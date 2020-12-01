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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Deque<List<Integer>> levelOrderBottom = new ArrayDeque<>();
        if (root == null) {
            return new ArrayList<>(levelOrderBottom);
        }
        Deque<TreeNode> currentLevelNodeQueue = new ArrayDeque<>();
        Deque<TreeNode> nextLevelNodeQueue = new ArrayDeque<>();
        currentLevelNodeQueue.addLast(root);
        List<Integer> levelValues = new ArrayList<>();
        while (!currentLevelNodeQueue.isEmpty()) {
            TreeNode node = currentLevelNodeQueue.removeFirst();
            levelValues.add(node.val);
            if (node.left != null) {
                nextLevelNodeQueue.addLast(node.left);
            }
            if (node.right != null) {
                nextLevelNodeQueue.addLast(node.right);
            }
            if (currentLevelNodeQueue.isEmpty()) {
                levelOrderBottom.addFirst(levelValues);
                levelValues = new ArrayList<>();
                currentLevelNodeQueue = nextLevelNodeQueue;
                nextLevelNodeQueue = new ArrayDeque<>();
            }
        }
        return new ArrayList<>(levelOrderBottom);
    }
}
