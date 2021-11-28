/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode singleStep = head;
        ListNode doubleStep = head;
        while (doubleStep != null) {
            doubleStep = doubleStep.next;
            singleStep = singleStep.next;
            if (doubleStep == null) {
                break;
            }
            doubleStep = doubleStep.next;
            if (doubleStep == singleStep) {
                return true;
            }
        }
        return false;
    }
}
