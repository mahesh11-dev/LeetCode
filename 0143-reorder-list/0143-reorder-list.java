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
    private ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode last = null;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = last;
            last = curr;
            curr = next;
        }
        return last;
    }
    public void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode next = slow.next;
        slow.next = null;
        ListNode newHead = reverse(next);
        ListNode curr = head;
        ListNode t2 = newHead;
        ListNode t1 = head;
        while(t1 != null && t2 != null){
            if(curr != t1){
                curr.next = t1;
                t1 = t1.next;
                curr = curr.next;
            }else{
                t1 = t1.next;
            }
            curr.next = t2;
            t2 = t2.next;
            curr = curr.next;
        }
        if(t1 != null){
            curr.next = t1;
        }else{
            curr.next = t2;
        }
    }
}