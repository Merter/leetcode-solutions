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
    public ListNode oddEvenList(ListNode head) {
        if (head == null) { 
            return null;
        }
        ListNode evenHead = null;
        ListNode evenTail = null;
        ListNode current = head;
        while (current.next != null) {
            ListNode temp = current.next;
            current.next = temp.next;
            temp.next = null;
            if (evenTail == null) {
                evenTail = temp;
                evenHead = temp;
            } else {
                evenTail.next = temp;
                evenTail = temp;
            }
            if (current.next == null) break;
            current = current.next;
        }
        current.next = evenHead;
        return head;
    }
}
