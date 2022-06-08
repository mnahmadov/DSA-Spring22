// Link to the Maximum Depth of Binary Tree problem on Leetcode: https://leetcode.com/problems/maximum-depth-of-binary-tree/

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
    // Even though it is not required for this question
    // we usually keep track of the nodes that we visit when we use DFS
    // in order to avoid cycles that result in infinite loop kind of a behavior
    public int maxDepth(TreeNode root) {
        // The needed chunk of code for this problem - the actual DFS
        // once the node becomes null, that means we reached to an end
        // so we can return 0
        if (root == null) {
            return 0;
        }
        
        // here we just check what is the depth of left subtree and right subtree
        int left = maxDepth(root.left);        
        int right = maxDepth(root.right);
        
        // once we know their depth, we can take the max of them and add 1 since we know that
        // we are currently one level upper than the children
        return Math.max(left, right) + 1;
    }
}
