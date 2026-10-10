/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        ListNode temp1 = headA;
        ListNode temp2 = headB;
        int n1 = 0;
        int n2 = 0;
        while(temp1 != null){
            n1++;
            temp1 = temp1.next;
        }
        while(temp2 != null){
            n2++;
            temp2 = temp2.next;
        }
        temp1 = headA;
        temp2 = headB;
        if(n1 < n2){
            int d = n2 - n1;
            while(d != 0){
                d--;
                temp2 = temp2.next;
            }
            // for(int i=0; i<=d; i++){
            //     temp2 = temp2.next;
            // }
        }else if(n2 < n1){
            int d = n1 - n2;
            while(d != 0){
                d--;
                temp1 = temp1.next;
            }
            // for(int i=0; i<=d; i++){
            //     temp1 = temp1.next;
            // }
        }
        while(temp2 != temp1){
            // if(temp1 == temp2){
            //     return temp1;
            // }
            temp1 = temp1.next;
            temp2 = temp2.next;
        } 
        return temp1;
    }
}