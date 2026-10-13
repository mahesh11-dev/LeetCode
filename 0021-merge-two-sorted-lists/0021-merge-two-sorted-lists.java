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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        ListNode dummyNode = new ListNode(-1);
        ListNode curr = dummyNode;
        ListNode temp1 = list1;
        ListNode temp2 = list2;
        while(temp1 != null && temp2 != null){
            if(temp1.val < temp2.val){
                curr.next = temp1;
                temp1 = temp1.next;
                curr = curr.next;
            }else{
                curr.next = temp2;
                temp2 = temp2.next;
                curr = curr.next;
            }
        }
        while(temp1 != null){
            curr.next = temp1;
            temp1 = temp1.next;
            curr = curr.next;
        }
        while(temp2 != null){
            curr.next = temp2;
            temp2 = temp2.next;
            curr = curr.next;
        }
        return dummyNode.next;
    }
}