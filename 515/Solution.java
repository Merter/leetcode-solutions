class Solution {
    public List<Integer> largestValues(TreeNode root) {
        ArrayList<Integer> maxInRows = new ArrayList<>();
        if (root == null) {
            return maxInRows;
        }
        Deque<TreeNode> currentRowNodeQueue = new ArrayDeque<>();
        Deque<TreeNode> nextRowNodeQueue = new ArrayDeque<>();
        int maxInRow = Integer.MIN_VALUE;
        
        currentRowNodeQueue.addLast(root);
        while (!currentRowNodeQueue.isEmpty()) {
            TreeNode node = currentRowNodeQueue.removeFirst();
            if (node.left != null) {
                nextRowNodeQueue.addLast(node.left);
            }
            if (node.right != null) {
                nextRowNodeQueue.addLast(node.right);
            }
            if (node.val > maxInRow) {
                maxInRow = node.val;
            }
            if (currentRowNodeQueue.isEmpty()) {
                maxInRows.add(maxInRow);
                maxInRow = Integer.MIN_VALUE;
                currentRowNodeQueue = nextRowNodeQueue;
                nextRowNodeQueue = new ArrayDeque<>();
            }
        }        
        return maxInRows;        
    }
}
