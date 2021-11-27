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
    public boolean isSymmetric(TreeNode root) {
        ArrayList<TreeNode> currentLevel = new ArrayList<>();
        currentLevel.add(root);
        ArrayList<TreeNode> nextLevel = new ArrayList<>();
        while (! currentLevel.isEmpty()) {
            for (TreeNode current : currentLevel) {
                if (current != null) {
                    nextLevel.add(current.left);
                    nextLevel.add(current.right);
                }
            }
            if (! isLevelSymmetric(nextLevel)) {
                return false;
            }
            currentLevel = nextLevel;
            nextLevel = new ArrayList<>();
        }        
        return true;
    }
    
    private boolean isLevelSymmetric(ArrayList<TreeNode> level) {
        for (int i=0; i<level.size()/2; i++) {
            TreeNode left = level.get(i);
            TreeNode right = level.get(level.size()-i-1);
            if (left==null && right==null) {
                continue;
            }
            if (left==null || right==null) {
                return false;
            }
            if (left.val != right.val) {
                return false;
            }
        }
        return true;
    }
}
