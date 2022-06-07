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
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) { // if we do not find the node in our tree
            return null;
        }
        if (root.val == val){
            // if we find it return the subtree
            return root;
        }
        
        if (val < root.val) {
            // if the value is less than the value of the current node
            // do the search on the left subtree
            return searchBST(root.left, val);
        }
        
        else {
            // if the value is obviously greater than the value of the current node
            // do the search on the right subtree
            return searchBST(root.right, val);
        }
    }
}