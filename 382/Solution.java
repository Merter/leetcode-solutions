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

    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    private ArrayList<Integer> numbers;
    
    public Solution(ListNode head) {
        numbers = new ArrayList<>();
        for (ListNode node=head; head!=null; head=head.next) {
            numbers.add(node.val);
        }
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        int randomIndex = ThreadLocalRandom.current().nextInt(0, numbers.size());
        return numbers.get(randomIndex);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */