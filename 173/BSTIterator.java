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
class BSTIterator {

    private final Deque<TreeNode> nextNodesStack = new ArrayDeque<>();
    private TreeNode currentNode;
    
    public BSTIterator(final TreeNode root) {
        final TreeNode leftmostChild = findLeftmostChild(root);
        nextNodesStack.push(leftmostChild);
        currentNode = null;
    }
        
    /** @return the next smallest number */
    public int next() {
        currentNode = nextNodesStack.pop();
        if (currentNode.right != null) {
            final TreeNode leftmostChild = findLeftmostChild(currentNode.right);
            nextNodesStack.push(leftmostChild);                
        }
        return currentNode.val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if (nextNodesStack.isEmpty()) {
            return currentNode.right != null;
        }        
        return true;
    }
    
    private TreeNode findLeftmostChild(final TreeNode node) {
        if (node.left == null) {
            return node;
        }
        nextNodesStack.push(node);
        return findLeftmostChild(node.left);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */