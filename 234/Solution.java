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
    public boolean isPalindrome(final ListNode head) {
        ListNode singleRunner = head;
        ListNode doubleRunner = head;
        final Deque<Integer> stack = new ArrayDeque<>();        
        while (doubleRunner != null) {
            stack.push(singleRunner.val);
            doubleRunner = doubleRunner.next;
            if (doubleRunner == null) {
                break;
            }
            singleRunner = singleRunner.next;
            doubleRunner = doubleRunner.next;
        }
        while (singleRunner != null) {
            if (singleRunner.val != stack.pop()) {
                return false;
            }
            singleRunner = singleRunner.next;
        }
        return stack.isEmpty();
    }
}
