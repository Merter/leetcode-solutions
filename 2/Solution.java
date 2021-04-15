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
    public ListNode addTwoNumbers(final ListNode l1, final ListNode l2) {
        boolean carry = false;
        ListNode sumList = null;
        ListNode sumRunner = sumList;
        ListNode l1Runner = l1;
        ListNode l2Runner = l2;
        while (l1Runner != null) {
            int sum = l1Runner.val;
            if (l2Runner != null) {
                sum += l2Runner.val;
                l2Runner = l2Runner.next;
            }
            l1Runner = l1Runner.next;
            sum += carry ? 1 : 0;
            if (sum >= 10) {
                carry = true;
                sum = sum % 10;
            } else {
                carry = false;
            }
            ListNode sumDigit = new ListNode(sum);
            if (sumList == null) {
                sumList = sumDigit;
                sumRunner = sumList;
            } else {
                sumRunner.next = sumDigit;
                sumRunner = sumDigit;
            }
        }
        while (l2Runner != null) {
            int sum = l2Runner.val;
            l2Runner = l2Runner.next;
            sum += carry ? 1 : 0;
            if (sum >= 10) {
                carry = true;
                sum = sum % 10;
            } else {
                carry = false;
            }
            ListNode sumDigit = new ListNode(sum);
            sumRunner.next = sumDigit;
            sumRunner = sumDigit;
        }
        if (carry) {
            ListNode sumDigit = new ListNode(1);
            sumRunner.next = sumDigit;
            sumRunner = sumRunner.next;            
        }
        return sumList;
    }
}
