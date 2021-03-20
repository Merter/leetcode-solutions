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
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        final Set<ListNode> uniqueListNodes = new HashSet<>();
        ListNode runner = headA;
        while (runner != null) {
            uniqueListNodes.add(runner);
            runner = runner.next;
        }
        runner = headB;
        while (runner != null) {
            if (uniqueListNodes.contains(runner)) {
                return runner;
            }
            runner = runner.next;
        }
        return null;   // no intersection
    }
}
