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

        ListNode head = new ListNode(0);
        ListNode dummy = head;
        

        ListNode curr1 = l1;
        ListNode curr2 = l2;

        int carry = 0;
        while(curr1 != null || curr2 != null || carry != 0) {
            int val1 = curr1 != null ? curr1.val : 0;
            int val2 = curr2 != null ? curr2.val : 0;

            int sum = val1 + val2 + carry;
            int rem = sum % 10;
            carry = sum / 10;

            ListNode temp = new ListNode(rem);
            dummy.next = temp;
            dummy = dummy.next;

            curr1 = curr1 != null ? curr1.next : null;
            curr2 = curr2 != null ? curr2.next : null;
        }


        // while(curr1 != null) {
        //     int val1 = curr1.val;
        //     int sum = val1 + carry;

        //     int rem = sum % 10;
        //     carry = sum / 10;

        //     ListNode temp = new ListNode(rem);
        //     dummy.next = temp;
        //     dummy = dummy.next;

        //     curr1 = curr1.next;
        // }

        // while(curr2 != null) {
        //     int val2 = curr2.val;
        //     int sum = val2 + carry;

        //     int rem = sum % 10;
        //     carry = sum / 10;

        //     ListNode temp = new ListNode(rem);
        //     dummy.next = temp;
        //     dummy = dummy.next;

        //     curr2 = curr2.next;
        // }

        // if(carry != 0) {
        //     ListNode temp = new ListNode(carry);
        //     dummy.next = temp;
        // }

        return head.next;        
    }
}
