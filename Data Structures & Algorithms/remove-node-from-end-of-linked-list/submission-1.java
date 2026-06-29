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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || head.next == null)
            return null;

        ListNode dummy = new ListNode();
        dummy.next = head;

        
        ListNode second = head;
        ListNode first = dummy;
        while(n > 0){
            second = second.next;
            n--;
        }
        
        while(second != null ){ // loop until end
            second = second.next;
            first = first.next;

        }
        // first.next is the node we need to remove (nth node from end)

        first.next = first.next.next;

        return dummy.next;
    }
}
