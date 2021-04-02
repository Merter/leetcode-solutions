/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class RecursiveSolution {
    public ListNode reverseList(ListNode node) {
        if (node==null)
            return node;
        ListNode endOfCircularList = recursiveReversal(node);
        ListNode temp = endOfCircularList.next;
        endOfCircularList.next = null;
        return temp;
    }
    
    private ListNode recursiveReversal(ListNode node) {
        if (node.next == null) {
            node.next = node;
            return node;
        }
        ListNode remainingReversed = recursiveReversal(node.next);
        ListNode temp = remainingReversed.next;
        remainingReversed.next = node;
        node.next = temp;
        return node;
    }    
}
