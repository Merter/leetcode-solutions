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
    public ListNode insertionSortList(ListNode head) {
        ListNode sortedHead = new ListNode();
        ListNode current = head;
        while (current != null){
            ListNode sortedPrev = sortedHead;
            ListNode sortedCurr = sortedHead.next;
            while (sortedCurr != null) {
                if (current.val < sortedCurr.val) {
                    break;
                }
                sortedPrev = sortedCurr;
                sortedCurr = sortedCurr.next;
            }
            ListNode newSorted = new ListNode(current.val, sortedCurr);
            sortedPrev.next = newSorted;
            current = current.next;
        }
        return sortedHead.next;
    }
}
