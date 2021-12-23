/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if (head == null) return;
        if (head.next == null) return;
        ListNode reversedMiddle = reverseList(halveList(head));

        ListNode headRunner = head;
        ListNode middleRunner = reversedMiddle;
        while (middleRunner!=null && headRunner!=null) {
            ListNode temp = headRunner.next;
            headRunner.next = middleRunner;
            middleRunner = middleRunner.next;
            headRunner.next.next = temp;
            headRunner = temp;
        }
    }
    
    private ListNode halveList(ListNode head) {
        if (head == null) return null;
        ListNode runByOne = head;
        ListNode runByTwo = head;
        while (true) {
            runByTwo = runByTwo.next;
            if (runByTwo == null) break;
            runByTwo = runByTwo.next;
            if (runByTwo == null) break;
            runByOne = runByOne.next;
        }
        return runByOne;        
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

    private void reorderListWithStack(ListNode head) {
        if (head.next == null) {
            return;
        }
        ListNode singleRunner = head;
        ListNode doubleRunner = head;
        while (true) {
            doubleRunner = doubleRunner.next;
            if (doubleRunner == null) break;
            doubleRunner = doubleRunner.next;
            if (doubleRunner == null) break;
            singleRunner = singleRunner.next;
        }
        // reverse the right half of the list by using a stack
        Deque<ListNode> stack = new ArrayDeque<>();
        while (singleRunner.next != null) {
            ListNode temp = singleRunner.next;
            singleRunner.next = temp.next;
            temp.next = null;
            stack.push(temp);
        }
        // insert the nodes in stack through the left half of the list
        singleRunner = head;
        while (! stack.isEmpty()) {
            ListNode temp = stack.pop();
            temp.next = singleRunner.next;
            singleRunner.next = temp;
            singleRunner = temp.next;
        }
    }   
}
