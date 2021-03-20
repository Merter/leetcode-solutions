/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class ConstantMemorySolution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        final int lengthA = lengthOfLinkedList(headA);
        final int lengthB = lengthOfLinkedList(headB);
        final ListNode longerList = lengthA>lengthB ? headA : headB;
        final ListNode shorterList = lengthA>lengthB ? headB : headA;

        ListNode longerRunner = longerList;
        int excessLength = Math.abs(lengthA-lengthB);
        while (excessLength > 0) {
            excessLength--;
            longerRunner = longerRunner.next;
        }

        ListNode shorterRunner = shorterList;
        while (longerRunner != null) {
            if (longerRunner == shorterRunner) {
                return longerRunner;
            }
            longerRunner = longerRunner.next;
            shorterRunner = shorterRunner.next;
        }
        return null;
    }
    
    private int lengthOfLinkedList(final ListNode linkedList) {
        int lengthOfLinkedList = 0;
        ListNode runner = linkedList;
        while (runner != null) {
            lengthOfLinkedList++;
            runner = runner.next;
        }
        return lengthOfLinkedList;
    }
}