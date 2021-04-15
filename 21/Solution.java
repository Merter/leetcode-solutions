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
    public ListNode mergeTwoLists(final ListNode l1, final ListNode l2) {
        
        ListNode l1Runner = l1;
        ListNode l1Prev = null;
        ListNode l2Runner = l2;
        ListNode l2Prev = null;
        ListNode sortedRunner = null;
        ListNode sortedHead = null;
        while (l1Runner != null) {
            if (l2Runner == null) {
                if (sortedHead == null) {
                    sortedHead = l1Runner;
                } else {
                    sortedRunner.next = l1Runner;
                }
                return sortedHead;
            }
            if (l1Runner.val < l2Runner.val) {
                if (sortedHead == null) {
                    sortedHead = l1Runner;
                    sortedRunner = sortedHead;
                } else {
                    sortedRunner.next = l1Runner;
                    sortedRunner = sortedRunner.next;
                }
                l1Runner = l1Runner.next;
            } else {
                if (sortedHead == null) {
                    sortedHead = l2Runner;
                    sortedRunner = sortedHead;
                } else {
                    sortedRunner.next = l2Runner;
                    sortedRunner = sortedRunner.next;
                }
                l2Runner = l2Runner.next;
            }
            sortedRunner.next = null;
        }
        if (sortedRunner != null) {
            sortedRunner.next = l2Runner;            
        } else {
            sortedHead = l2Runner;
        }
        return sortedHead;
    }
}
