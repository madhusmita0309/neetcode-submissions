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
    public void reorderList(ListNode head) {

        if(head == null)
            return;

        ListNode slow = head;
        ListNode fast = head;

        // divide into 2 lists
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            
        }
        ListNode l1 = head; ListNode l2 = slow.next;
// imp
        slow.next = null;

        // reverse list2
        ListNode curr = l2;
        ListNode prev = null;
        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;

            curr = temp;
        }

        l2 = prev;

        //merge list1 & list2

        ListNode dummy = new ListNode();
        curr = dummy;
        boolean flip = true;
        while(l1 != null || l2 != null){
            if(l1 == null){
                curr.next = l2;
                l2 = l2.next;
            }else if(l2 == null){
                curr.next = l1;
                l1 = l1.next;
            }else if(flip){
                curr.next = l1;
                l1 = l1.next;
                
            }else{
                curr.next = l2;
                l2 = l2.next;

            }
            curr = curr.next;
            flip = !flip;
        }

        
    }
}
