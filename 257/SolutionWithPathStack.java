/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class SolutionWithPathStack {

    private ArrayDeque<Integer> path = new ArrayDeque<Integer>();
    private List<String> allRootToLeafPaths = new LinkedList<String>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root != null) {
            pathFinder(root);
        }
        return allRootToLeafPaths;
    }

    private void pathFinder(TreeNode root) {
        path.push(root.val);
        boolean hasChild = false;
        if (root.left != null) {
            hasChild = true;
            pathFinder(root.left);
            path.pop();
        }
        if (root.right!= null) {
            hasChild = true;
            pathFinder(root.right);
            path.pop();
        }
        if (!hasChild) {
            allRootToLeafPaths.add(textFromPath());
        }
    }
    
    private String textFromPath() {
        ArrayDeque<Integer> aux = new ArrayDeque<Integer>();
        StringBuilder sb = new StringBuilder();
        while (path.size() > 0) {
            aux.push(path.pop());
        }
        while (aux.size() > 0) {
            int num = aux.pop();
            sb.append(num);
            if (aux.size()>0) sb.append("->");
            path.push(num);
        }
        return sb.toString();
    }
}