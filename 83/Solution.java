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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode curr = head;
        while (curr.next != null) {
            if (curr.val != curr.next.val) {
                curr = curr.next;
                continue;
            }
            ListNode temp = curr.next;
            curr.next = temp.next;
            temp.next = null;
        }
        return head;
    }
}
