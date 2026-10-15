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
    private ListNode reverse(ListNode left){
        ListNode last = null;
        ListNode curr = left;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = last;
            last = curr;
            curr = next;
        }
        return last;
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || head.next == null || left == right){
            return head;
        }
        ListNode leftNode = head;
        int leftCount = 1;
        while(leftCount != left){
            leftCount++;
            leftNode = leftNode.next;
        }
        ListNode rightNode = head;
        int rightCount = 1;
        while(rightCount != right){
            rightCount++;
            rightNode = rightNode.next;
        }
        if(leftNode == head){
            if(rightNode.next == null)
                return reverse(leftNode);
        }
        ListNode back = null;
        ListNode curr = head;
        while(curr != leftNode){
            back = curr;
            curr = curr.next;
        }
        ListNode front = rightNode.next;
        rightNode.next = null;
        ListNode reverseHead = reverse(leftNode);
        leftNode.next = front;
        if(back == null){
            return rightNode;
        }
        back.next = rightNode;
        return head;
    }
}