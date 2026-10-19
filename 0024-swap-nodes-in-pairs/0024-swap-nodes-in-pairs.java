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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        if(head.next.next == null){
            return reverse(head);
        }
        ListNode nextNode = head.next.next;
        head.next.next = null;
        ListNode last = head;
        head = reverse(head);
        ListNode slow = nextNode;
        ListNode fast = nextNode.next;
        if(fast == null){
            last.next = nextNode;
            return head;
        }
        while(fast != null){
            nextNode = fast.next;
            fast.next = null;
            last.next = reverse(slow);
            last = slow;
            slow = nextNode;
            if(nextNode == null){
                last.next = nextNode;
                return head;
            }else{
                fast = nextNode.next;
            }
        }
        if(nextNode != null){
            last.next = nextNode;
        }
        return head;
    }
}