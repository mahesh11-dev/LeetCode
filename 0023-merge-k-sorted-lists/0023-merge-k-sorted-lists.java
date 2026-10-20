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
    private ListNode mergeLL(ListNode temp1, ListNode temp2){
        ListNode t1 = temp1;
        ListNode t2 = temp2;
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while(t1 != null && t2 != null){
            if(t1.val < t2.val){
                curr.next = t1;
                t1 = t1.next;
                curr = curr.next;
            }else{
                curr.next = t2;
                t2 = t2.next;
                curr = curr.next;
            }
        }
        if(t1 != null){
            curr.next = t1;
        }else if(t2 != null){
            curr.next = t2;
        }
        return dummy.next;
    }
    private ListNode mergeSort(ListNode[] lists, int low, int high){
        if(low == high){ 
            return lists[low];
        }
        int mid = (low + high)/2;
        return mergeLL(mergeSort(lists, low, mid), mergeSort(lists, mid+1, high));
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        return mergeSort(lists, 0, lists.length-1);
    }
}