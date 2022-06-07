/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<Integer> result = new LinkedList<>();
    // a linked-list where we store our node values
    public List<Integer> preorderTraversal(TreeNode root) {
        preorder_helper(root);
        // start from the root
        // once our recursive function is done, 
        // we have our linked-list of node values 
        // that can be returned
        return result;
    }
    
    public void preorder_helper(TreeNode root) {
        if (root == null) {
            // our base case, when we see no node, 
            // then it is time not to move on from that branch
            return;
        }
        // we first take our current node's value 
        result.add(root.val);
        // traverse the left subtree
        preorder_helper(root.left);
        // traverse the right subtree
        preorder_helper(root.right);   
    }
}