/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode node) {
        ListNode runner = node;
        ListNode reversedHead = null;
        while (runner != null) {
            if (reversedHead == null) {
                reversedHead = runner;
                runner = runner.next;
                reversedHead.next = null;
            } else {
                ListNode temp = runner.next;
                runner.next = reversedHead;
                reversedHead = runner;
                runner = temp;
            }
        }
        return reversedHead;
    }    
}
