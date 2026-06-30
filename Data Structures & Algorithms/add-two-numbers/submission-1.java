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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        int sum = 0;
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        while(l1 != null || l2 != null){
            int num1 = l1 == null ? 0 : l1.val;
            int num2 = l2 == null ? 0 : l2.val;
            int ans = carry + num1 + num2;
            sum = ans %10;
            carry = ans/10;
            ListNode newNode = new ListNode(sum);
            curr.next = newNode;
            curr = curr.next;

            if(l1 != null && l2 != null){
                l1 = l1.next;
                l2 = l2.next;
            }
            else if(l1 == null && l2 != null)
                l2 = l2.next;
            else if(l2 == null && l1 != null)
                l1 = l1.next;

        }

        if(carry > 0){
            ListNode newNode = new ListNode(carry);
            curr.next = newNode;
            curr = curr.next;
        }

        return dummy.next;

    }
}
