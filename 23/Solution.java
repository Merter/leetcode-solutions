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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode sortedHead = null;
        ListNode sortedTail = sortedHead;
        while (true) {
            int minIndex = findMinListIndex(lists);       
            if (minIndex == -1) {
                break;
            }
            // remove minHead and add it to the sortedTail
            // update lists
            ListNode minHead = lists[minIndex];
            ListNode temp = minHead.next;
            minHead.next = null;
            lists[minIndex] = temp;
            if (sortedTail == null) {
                sortedHead = minHead;
            } else {
                sortedTail.next = minHead;
            }
            sortedTail = minHead;
        }
        return sortedHead;
    }
    
    private int findMinListIndex(ListNode[] lists) {
        int minIndex = -1;
        for (int i=0; i<lists.length; i++) {
            if (lists[i] == null) {
                continue;
            }
            if (minIndex==-1 || lists[minIndex].val>lists[i].val) {
                minIndex = i;
            }
        }
        // System.out.println("MINDEX: " + minIndex);
        return minIndex;
    }
}