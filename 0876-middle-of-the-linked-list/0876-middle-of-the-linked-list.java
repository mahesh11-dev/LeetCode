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
    public ListNode middleNode(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        int count = 0;
        ListNode temp = head;
        while(temp != null){
            count++;
            temp = temp.next;
        }
        int targetPrev = count / 2;
        count = 1;
        temp = head;
        while(temp != null){
            if(count == targetPrev){
                head = temp.next;
                temp.next = null;
                break;
            }
            count++;
            temp = temp.next;
        }
        return head;
        
    }
}