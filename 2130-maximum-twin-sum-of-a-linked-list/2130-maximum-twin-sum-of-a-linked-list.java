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
    private ListNode reverseLL(ListNode head){
        if(head.next == null){
            return head;
        }
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
    public int pairSum(ListNode head) {
        if(head == null || head.next == null){
            return -1;
        }
        if(head.next.next == null){
            return head.val + head.next.val;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode newTail = slow.next;
        //ListNode newHead = fast.next;
        //slow.next = null;
        //reverseLL(slow.next);
        ListNode newHead = reverseLL(slow.next);

        int sum = -1;
        int maxTwinSum = Integer.MIN_VALUE;
        ListNode temp1 = head;
        ListNode temp2 = newHead;
        while(temp1 != null && temp2 != null){
            sum = temp1.val + temp2.val;
            maxTwinSum = Math.max(maxTwinSum,sum);
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return maxTwinSum;
    }
}