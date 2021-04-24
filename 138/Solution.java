/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(final Node head) {
        if (head == null) {
            return null;
        }
        final Node newHead = new Node(head.val);
        Node newPointer = newHead;
        Node oldPointer = head.next;
        final Map<Node, Node> oldNode2NewNode = new HashMap<>();
        oldNode2NewNode.put(head, newHead);
        // first pass to create nodes WITHOUT RANDOMS
        while (oldPointer != null) {
            final Node newNode = new Node(oldPointer.val);
            oldNode2NewNode.put(oldPointer, newNode);
            newPointer.next = newNode;
            oldPointer = oldPointer.next;
            newPointer = newPointer.next;
        }
        // second pass for adding the random nodes
        oldPointer = head;
        newPointer = newHead;
        while (oldPointer != null) {
            final Node oldRandom = oldPointer.random;
            final Node newRandom = oldNode2NewNode.get(oldRandom);
            newPointer.random = newRandom;
            oldPointer = oldPointer.next;
            newPointer = newPointer.next;
        }
        return newHead;
    }
}
