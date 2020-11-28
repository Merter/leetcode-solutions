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
    public ListNode addTwoNumbers(ListNode num1, ListNode num2) {
        ListNode reversedNum1 = Solution.reverseInPlace(num1);
        ListNode reversedNum2 = Solution.reverseInPlace(num2);

        boolean isCarry = false;
        ListNode current1 = reversedNum1;
        ListNode current2 = reversedNum2;
        ListNode sum = null;
        while (current1 != null) {
            int digitValue = current1.val + (isCarry ? 1 : 0);
            isCarry = false;
            if (current2 != null) {
                digitValue += current2.val;
                current2 = current2.next;
            }
            if (digitValue >= 10) {
                isCarry = true;
                digitValue = digitValue % 10;
            }
            sum = addDigitToList(digitValue, sum);
            current1 = current1.next;
        }
        while (current2 != null) {
            int digitValue = current2.val + (isCarry ? 1 : 0);
            isCarry = false;
            if (digitValue >= 10) {
                isCarry = true;
                digitValue = digitValue % 10;
            }
            sum = addDigitToList(digitValue, sum);
            current2 = current2.next;
        }
        if (isCarry) {
            sum = addDigitToList(1, sum);
        }
        return sum;
    }
    
    private static ListNode addDigitToList(int digitValue, ListNode head) {
        ListNode newDigitNode = new ListNode(digitValue);
        newDigitNode.next = head;
        return newDigitNode;
    }
    
    private static ListNode reverseInPlace(ListNode headOfList) {
        ListNode current = headOfList;
        ListNode previous = null;
        while (current != null) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        headOfList.next = null;
        return previous;
    }

    public ListNode addTwoNumbersNonDestructive(ListNode num1, ListNode num2) {
        Deque<Integer> stack1 = convertListToStack(num1);
        Deque<Integer> stack2 = convertListToStack(num2);
        
        ListNode sum = null;
        boolean isCarry = false;
        while (!stack1.isEmpty()) {
            int digitValue = stack1.pop() + (isCarry ? 1 : 0);
            isCarry = false;
            if (!stack2.isEmpty()) {
                digitValue += stack2.pop();
            }
            if (digitValue >= 10) {
                isCarry = true;
                digitValue = digitValue % 10;
            }
            sum = addDigitToList(digitValue, sum);
        }
        while (!stack2.isEmpty()) {
            int digitValue = stack2.pop() + (isCarry ? 1 : 0);
            isCarry = false;
            if (digitValue >= 10) {
                isCarry = true;
                digitValue = digitValue % 10;
            }
            sum = addDigitToList(digitValue, sum);
        }
        if (isCarry) {
            sum = addDigitToList(1, sum);
        }
        return sum;
    }
        
    private Deque<Integer> convertListToStack(ListNode num) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (ListNode node = num; node != null; node = node.next) {
            stack.push(node.val);
        }
        return stack;
    }
}
