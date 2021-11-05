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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode endMarker = head;
        ListNode prevMarker = head;
        for (int i=0; i<n; i++) {
            endMarker = endMarker.next;
        }
        if (endMarker == null) { // removing the head
            head = head.next;
            return head;
        }
        while (true) {
            if (endMarker.next == null) {
                removeNextNode(prevMarker);
                return head;
            }
            prevMarker = prevMarker.next;
            endMarker = endMarker.next;
        }
    }
    
    private void removeNextNode(ListNode prevMarker) {
        ListNode newNext = prevMarker.next.next;
        prevMarker.next = newNext;
    }
}
