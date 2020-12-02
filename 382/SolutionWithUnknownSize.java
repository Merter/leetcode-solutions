/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
public class SolutionWithUnknownSize {

    private ListNode head;
    private int size;

    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public SolutionWithUnknownSize(ListNode head) {
        this.head = head;
        this.size = 0;
        learnSize();
    }
    
    private void learnSize() {
        for (ListNode curr=head; curr!=null; curr=curr.next) {
            size++;
        }
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        int position = ThreadLocalRandom.current().nextInt(0, size);
        ListNode curr = head;
        for (int i=0; i<position; i++) {
            curr = curr.next;
        }
        return curr.val;
    }
}

/**
 * Your SolutionWithUnknownSize object will be instantiated and called as such:
 * SolutionWithUnknownSize obj = new SolutionWithUnknownSize(head);
 * int param_1 = obj.getRandom();
 */