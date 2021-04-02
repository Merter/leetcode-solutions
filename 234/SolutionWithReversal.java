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
class SolutionWithReversal {
    public boolean isPalindrome(final ListNode head) {
        if (head.next == null) {
            // single node
            return true;
        }
        ListNode prev = null;
        ListNode singleRunner = head;
        ListNode doubleRunner = head;
        while (doubleRunner != null) {
            doubleRunner = doubleRunner.next;
            if (doubleRunner == null) {
                break;
            }
            prev = singleRunner;
            singleRunner = singleRunner.next;
            doubleRunner = doubleRunner.next;
        }
        prev.next = null;
        ListNode first = head;
        ListNode second = reverseList(singleRunner);
        while (first!=null && second!=null) {
            if (first.val != second.val) {
                return false;
            }
            first = first.next;
            second = second.next;
        }
        if (first == null) {
            return second==null || second.next==null;
        }
        return first.next == null;
    }
    
    private ListNode reverseList(ListNode node) {
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
