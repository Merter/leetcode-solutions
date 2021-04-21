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
        ListNode lastMarker = head;
        for (int i=0; i<n; i++) {
            lastMarker = lastMarker.next;
        }
        ListNode toBeRemoved = null;
        if (lastMarker == null) {
            toBeRemoved = head;
            head = head.next;
        } else {
            ListNode nPrev = head;
            while (lastMarker.next != null) {
                nPrev = nPrev.next;
                lastMarker = lastMarker.next;
            }
            toBeRemoved = nPrev.next;
            nPrev.next = toBeRemoved.next;            
        }
        toBeRemoved.next = null;
        return head;
    }
}
