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
class BfsSolution {
    public int deepestLeavesSum(TreeNode root) {
        Deque<TreeNode> parents = new ArrayDeque<>();
        Deque<TreeNode> children = new ArrayDeque<>();
        parents.addLast(root);
        int deepestLeavesSum = 0;
        while (! parents.isEmpty()) {
            final TreeNode parent = parents.removeFirst();
            deepestLeavesSum += parent.val;
            if (parent.left != null) {
                children.addLast(parent.left);
            }
            if (parent.right != null) {
                children.addLast(parent.right);
            }
            if (parents.isEmpty()) {
                if (children.isEmpty()) {
                    // reached to the deepest leaf level
                    break;
                }
                deepestLeavesSum = 0;
                parents = children;
                children = new ArrayDeque<>();
            }
        }
        return deepestLeavesSum;
    }
}
