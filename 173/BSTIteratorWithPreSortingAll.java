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
class BSTIteratorWithPreSortingAll {

    private ArrayList<Integer> sortedNodeValues = new ArrayList<>();
    private int iteratorPosition = 0;
    
    public BSTIterator(TreeNode root) {
        inOrderTraversal(root);
    }
    
    /** @return the next smallest number */
    public int next() {
        return sortedNodeValues.get(iteratorPosition++);
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return iteratorPosition < sortedNodeValues.size();
    }
    
    private void inOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left);
        sortedNodeValues.add(node.val);
        inOrderTraversal(node.right);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
 