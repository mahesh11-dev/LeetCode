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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode prev = head;
        ListNode temp = head.next;
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while(temp != null){
            if(temp.val == prev.val){
                while(temp != null && prev.val == temp.val){
                    temp = temp.next;
                }
                prev = temp;
                if(temp != null){
                    temp = temp.next;
                }
            }else{
                curr.next = prev;
                curr = curr.next;
                prev = temp;
                temp = temp.next;
            }
        }
        curr.next = prev;
        return dummy.next;
    }
}