/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapNodes(final ListNode head, final int k) {
        ListNode kthFromBeginning = head;
        for (int i=1; i<k; i++) {
            kthFromBeginning = kthFromBeginning.next;
        }
        ListNode kthFromEnd = head;
        ListNode endNode = kthFromBeginning;
        while (endNode.next != null) {
            kthFromEnd = kthFromEnd.next;
            endNode = endNode.next;
        }
        final int temp = kthFromBeginning.val;
        kthFromBeginning.val = kthFromEnd.val;
        kthFromEnd.val = temp;
        return head;
    }
}