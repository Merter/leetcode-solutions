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
    public int getDecimalValue(ListNode head) {
        int number = 0; // the nodes will not exceed 30, hence the number will definitely be a Java integer        
        for (ListNode current=head; current!=null; current=current.next) {
            number *= 2;
            number += current.val;
        }        
        return number;        
    }
}
