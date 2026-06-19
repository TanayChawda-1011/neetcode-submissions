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
        int len = 0;
        int index = -1;
        ListNode cur = head;

        while(cur != null) {
            cur = cur.next;
            len++;
        }

        index = len - n;

        if(index == 0)  return head.next;

        cur = head;
        ListNode prev = null;
        int i =  0;


        while(i <= index) {
            if(i == index) {
                prev.next = prev.next.next;
                break;
            }
            prev = cur;
            cur = cur.next;
            i++;
        }

        return head;
    }
}
