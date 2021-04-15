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
    public ListNode partition(ListNode head, int x) {
        ListNode greaterOrEqualHead = null;
        ListNode greaterOrEqualTail = null;
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            if (curr.val < x) {
                prev = curr;
                curr = curr.next;
                continue;
            }
            // remove from the one starting with head and add next to the greaterOrEqualTail
            final ListNode temp = curr.next;
            curr.next = null;
            if (prev == null) {
                if (greaterOrEqualTail == null) {
                    greaterOrEqualHead = curr;
                } else {
                    greaterOrEqualTail.next = curr;
                }
                head = temp;
                greaterOrEqualTail = curr;
            } else {
                prev.next = temp;
                if (greaterOrEqualTail == null) {
                    greaterOrEqualHead = curr;
                } else {
                    greaterOrEqualTail.next = curr;
                }
                greaterOrEqualTail = curr;
            }
            curr = temp;
        }
        // append greaterOrEqualHead to prev
        if (prev == null) {
            return greaterOrEqualHead;
        }
        prev.next = greaterOrEqualHead;
        return head;
    }
}
