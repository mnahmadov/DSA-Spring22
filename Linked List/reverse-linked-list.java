// Link to the Reverse Linked List problem on Leetcode: https://leetcode.com/problems/reverse-linked-list/

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
    public ListNode reverseList(ListNode head) {
        // We initialize a pointer that will point to the previous node of 
        // the node that we point to, while traversal
        // initially it is null
        ListNode prev = null;
        
        // while we have a node we need to do some stuff
        // here we just traverse the linked list
        while (head != null) {
            // we also initialize a reference to the next node of the current node
            // that we refernce to
            ListNode next_node = head.next;
            
            // here we change the direction of the link
            // meaning previously we had the link pointing to the next node
            // now we make it point to the previous node
            head.next = prev;
            
            // we move the pointers
            // in the next iteration
            // prev is going to be the current that we are pointing to
            prev = head;
            // and head would be the next node that we previously initialized a link to
            // so that we do not lose the links to that node
            head = next_node;
        }
        // at the end of this traversal head is going to be null
        // and prev is going to be the last node on the given linked list
        // since we flipped the direction of links
        // we can basically return prev which is a link to the last element
        return prev;
    }
}
