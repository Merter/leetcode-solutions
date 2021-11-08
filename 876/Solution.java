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
    public ListNode middleNode(ListNode head) {
        if (head.next == null) {
            return head;
        }
        if (head.next.next == null) {
            return head.next;
        }
        ListNode oneStepRunner = head;
        ListNode twoStepRunner = head;
        while (true) {
            oneStepRunner = oneStepRunner.next;
            if (twoStepRunner.next == null) {
                return oneStepRunner;
            }
            twoStepRunner = twoStepRunner.next;
            twoStepRunner = twoStepRunner.next;
            if (twoStepRunner==null || twoStepRunner.next==null) {
                return oneStepRunner;
            }            
        }
    }
}
