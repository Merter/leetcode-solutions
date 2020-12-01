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
    public TreeNode buildTree(int[] preOrder, int[] inOrder) {
        if (preOrder.length == 0) {
            return null;
        }
        Deque<Integer> preDeque = convertIntArrayToDeque(preOrder);
        Deque<Integer> inDeque = convertIntArrayToDeque(inOrder);
        return buildTreeWithRoot(preDeque, inDeque);
    }
    
    private TreeNode buildTreeWithRoot(Deque<Integer> preDeque, Deque<Integer> inDeque) {
        int rootValue = preDeque.removeFirst();
        Deque<Integer> leftDeque = new ArrayDeque<>();
        while (!inDeque.isEmpty() && inDeque.peekFirst()!=rootValue) {
            leftDeque.addLast(inDeque.removeFirst());
        }
        inDeque.removeFirst(); // remove the root value
        if (preDeque.isEmpty()) {
            return new TreeNode(rootValue);
        }
        TreeNode leftSubTree = null;
        if (!leftDeque.isEmpty()) {
            leftSubTree = buildTreeWithRoot(preDeque, leftDeque);
        }
        if (preDeque.isEmpty() || inDeque.isEmpty()) {
            return new TreeNode(rootValue, leftSubTree, null);
        }
        TreeNode rightSubTree = buildTreeWithRoot(preDeque, inDeque);
        return new TreeNode(rootValue, leftSubTree, rightSubTree);
    }
    
    private Deque<Integer> convertIntArrayToDeque(int[] numbers) {
        Deque<Integer> numbersInDeque = new ArrayDeque<>();
        for (int number : numbers) {
            numbersInDeque.addLast(number);
        }
        return numbersInDeque;
    }
}
