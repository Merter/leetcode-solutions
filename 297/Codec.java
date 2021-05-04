/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(final TreeNode root) {
        final StringBuilder stb = new StringBuilder();
        appendSubTree(root, stb);
        return stb.toString();
    }
    
    private void appendSubTree(final TreeNode node, final StringBuilder stb) {
        if (node == null) {
            return;
        }
        stb.append(node.val);
        stb.append("L");
        appendSubTree(node.left, stb);
        stb.append("R");
        appendSubTree(node.right, stb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(final String data) {
        return deserialize(data, 0, data.length());
    }
    
    private TreeNode deserialize(final String data, final int start, final int end) {
        if (start==data.length() || start==end) {
            return null;
        }
        final StringBuilder stb = new StringBuilder();
        int i = start;
        while (data.charAt(i) != 'L') {
            stb.append(data.charAt(i++));
        }
        final TreeNode node = new TreeNode(Integer.parseInt(stb.toString()));
        // now find the matching R
        i++;
        final int leftBegin = i;
        int leftCount = 1;
        while (leftCount > 0) {
            if (data.charAt(i) == 'L') {
                leftCount++;
            }
            if (data.charAt(i) == 'R') {
                leftCount--;
            }
            i++;
        }
        node.left = deserialize(data, leftBegin, i-1);
        node.right = deserialize(data, i, end);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
