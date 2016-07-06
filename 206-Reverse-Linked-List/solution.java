/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null)
            return head;
        ListNode cur = null;
        while(head != null) {
            ListNode next = head.next;
            head.next = cur;
            cur = head;
            head = next;
        }
        return cur;
    }
}