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
        ListNode dummyNode = new ListNode(0);
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode temp3 = dummyNode;
        int carry = 0;
        int sum = 0;
        int data1 = 0;
        int data2 = 0;
        int remainder = 0;
        while(temp1 != null && temp2 != null){
            data1 = temp1.val;
            data2 = temp2.val;
            sum = data1 + data2 + carry;
            remainder = sum % 10;
            carry = sum / 10;
            //new Node
            ListNode newNode = new ListNode(remainder);
            temp3.next = newNode;
            temp3 = temp3.next;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        while(temp1 != null){
            data1 = temp1.val;
            sum = data1 + carry;
            remainder = sum % 10;
            carry = sum / 10;
            //new Node
            ListNode newNode = new ListNode(remainder);
            temp3.next = newNode;
            temp3 = temp3.next;
            temp1 = temp1.next;
        }
        while(temp2 != null){
            data2 = temp2.val;
            sum = data2 + carry;
            remainder = sum % 10;
            carry = sum / 10;
            //new Node
            ListNode newNode = new ListNode(remainder);
            temp3.next = newNode;
            temp3 = temp3.next;
            temp2 = temp2.next;
        }
        if(carry != 0){
            ListNode newNode = new ListNode(carry);
            temp3.next = newNode;
            temp3 = temp3.next;
        }
        temp3.next = null;
        ListNode head = dummyNode.next;
        dummyNode.next = null;
        return head;
    }
}