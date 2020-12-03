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
    public TreeNode increasingBST(TreeNode root) {
        
        List<Integer> sortedNumbers = new ArrayList<>();
        treeToSortedList(root, sortedNumbers);
        TreeNode newRoot = new TreeNode(sortedNumbers.get(0));
        TreeNode lastNode = newRoot;
        for (int i=1; i<sortedNumbers.size(); i++) {
            TreeNode nextNode = new TreeNode(sortedNumbers.get(i));
            lastNode.right = nextNode;
            lastNode = nextNode;
        }
        return newRoot;
    }
    
    private void treeToSortedList(TreeNode node, List<Integer> sortedNumbers) {
        if (node.left != null) {
            treeToSortedList(node.left, sortedNumbers);
        }
        sortedNumbers.add(node.val);
        if (node.right != null) {
            treeToSortedList(node.right, sortedNumbers);
        }
    }
}