/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class DfsSolution {
    
    int maxDepth = Integer.MIN_VALUE;
    List<Integer> valuesAtMaxDepth = new LinkedList<>();
    
    public int deepestLeavesSum(TreeNode root) {
        dfs(root, 0);
        return valuesAtMaxDepth.stream().reduce(0, (a, b) -> a + b);
    }
    
    private void dfs(TreeNode node, int depth) {
        depth++;
        if (depth > maxDepth) {
            maxDepth = depth;
            valuesAtMaxDepth = new LinkedList<>();
        }
        if (depth == maxDepth) {
            valuesAtMaxDepth.add(node.val);
        }
        if (node.left != null) {
            dfs(node.left, depth);
        }
        if (node.right != null) {
            dfs(node.right, depth);
        }
    }
}
