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
    private ListNode getKthNode(ListNode temp,int k){
        int count = 1;
        while(temp != null && count < k){
            count++;
            temp = temp.next;
        }
        return temp;
    }
    private void reverse(ListNode temp){
        if(temp == null || temp.next == null){
            return;
        }
        ListNode curr = temp;
        ListNode last = null;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = last;
            last = curr;
            curr = next;
        }
        return;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode temp = head;
        ListNode prevNode = null;
        ListNode nextNode = null;
        while(temp != null){
            ListNode kthNode = getKthNode(temp,k);
            if(kthNode == null){
                if(prevNode != null){
                    prevNode.next = temp;
                }
                break;
            }
            nextNode = kthNode.next;
            kthNode.next = null;
            reverse(temp);
            if(temp == head){
                head = kthNode;
            }else{
                prevNode.next = kthNode;
            }
            prevNode = temp;
            temp = nextNode;
        }
        return head;
    }
}