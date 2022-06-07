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
    // a linked-list where we store our node values
    List<Integer> result = new LinkedList<>();
    
    public List<Integer> postorderTraversal(TreeNode root) {
        dfs(root); // start from the root
        // once our recursive function is done, 
        // we have our linked-list of node values 
        // that can be returned
        return result;
    }
    
    public void dfs(TreeNode root) {
        if (root == null) {
            // our base case, when we see no node, 
            // then it is time not to move on from that branch
            return;
        }
        // traverse the left subtree
        dfs(root.left);
            
        // traverse the right subtree
        dfs(root.right);
        
        // take the current node's value
        result.add(root.val);
    }
}