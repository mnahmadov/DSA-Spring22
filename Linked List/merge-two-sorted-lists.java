// Link to the Merge Two Sorted Lists problem on Leetcode: https://leetcode.com/problems/merge-two-sorted-lists/


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
        // We are initializing a dummy node that would be
        // the first node on our resulting linked list
        // we use this node to know where our list starts
        // and eventually we will use it to go through our resulting list
        ListNode dummy = new ListNode(0);
        ListNode head = dummy; // this is a new pointer/reference to the first
        // element of our resulting list
        
        // while we have not gone through at least one of the given lists entirely
        // meaning if we have 2 nodes from 2 given lists to compare
        // we need to do some stuff
        while (list1 != null && list2 != null) {
            // if the value of the node that we are pointing in the first given list
            // is less than the value of the node that we are pointing in the second given list
            if (list1.val < list2.val) {
                // then I need to take the element from the first list
                // put it onto our resulting list
                // and move the pointer to the next element on the list 
                // that we have taken the value from, in this case, it is the first list
                // and also move the pointer to the next element on our resulting list as well
                dummy.next = list1;
                list1 = list1.next;
            }
            
            // if the value of the node that we are pointing in the second given list
            // is less than or equal to the value of the node 
            // that we are pointing in the first given list
            else {
                // then I need to take the element from the second list
                // put it onto our resulting list
                // and move the pointer to the next element on the list 
                // that we have taken the value from, in this case, it is the second list
                dummy.next = list2;
                list2 = list2.next;
            }
            // and also move the pointer to the next node on our resulting list as well
            // so that we do not overwrite the new value onto the previous node
            dummy = dummy.next;
        }
        
        // after we gone through this while loop
        // that means either we have gone through one of the given lists
        // or both of them
        
        // now we need to check if we have gone through all of the nodes in both nodes
        // or not, if we haven't, which one is it that we haven't gone through

        // if we have something left on the first given list
        if (list1 != null) {
            // then we need to append the remaining nodes on the first given list
            // to our resulting list
            dummy.next = list1;
        }
        
        // otherwise, meaning if we have something left on the second given list
        else {
            // then we need to append the remaining nodes on the second given list
            // to our resulting list
            dummy.next = list2;
        }
        
        // at the end we can basically return head.next
        // since head was pointing to the dummy node that had value -1
        // remember, we initialized it at the beginning
        // so we do not need that node, what we need are the nodes that are 
        // after that dummy
        return head.next;
    }
}
