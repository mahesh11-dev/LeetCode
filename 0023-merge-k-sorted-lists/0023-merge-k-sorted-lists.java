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
    public ListNode mergeKLists(ListNode[] lists) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int temp = 0; temp<lists.length; temp++){
            ListNode t2 = lists[temp];
            while(t2 != null){
                list.add(t2.val);
                t2 = t2.next;
            }
        }
        Collections.sort(list);
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        int i = 0;
        while(i < list.size()){
            curr.next = new ListNode(list.get(i++));
            curr = curr.next;
        }
        return dummy.next;
    }
}