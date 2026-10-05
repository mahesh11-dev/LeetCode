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
        if(head.next == null && n == 1){
            return null;
        }
        ListNode temp = head;
        int count = 0;
        while(temp != null){
            count++;
            temp = temp.next;
        }
        int targetPrev = count - n;
        if(targetPrev == 0 && head.next != null){
            ListNode deleting = head;
            head = head.next;
            deleting.next = null;
            return head;
        }
        temp = head;
        count = 0;
        while(temp != null){
            count++;
            if(count == targetPrev){
                temp.next = temp.next.next;
            }
            temp = temp.next;
        }
        return head;
    }
}