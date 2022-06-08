// Link to the Range Sum of BST problem on Leetcode: https://leetcode.com/problems/range-sum-of-bst/

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
    public int rangeSumBST(TreeNode root, int low, int high) {
        int sum = 0; // initially our sum is 0
        if (root == null) { // if our root is empty then return the sum immediately
            return sum;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) { // if our queue is not empty then we need to do something
            TreeNode current = queue.remove(); // take a node that we have in our queue
            if (current.val >= low && current.val <= high) {
                // if the value of the current node that we are at
                // falls in the range then add it to our sum
                sum += current.val;
            }
            if (current.left != null && current.val > low) {
                // if we have a left subtree and 
                // value of the current node is greater than low or 
                // minimum number in our range (it can also be called this way)
                // then there can be a value in the left subtree 
                // that can fall in the range and we need to check it
                queue.add(current.left);
                
                // ortherwise, meaning if the current value is already less than low or 
                // equal to the low then there is no meaning of checking left subtree
                
            }
            
            if (current.right != null && current.val < high) {
                // if we have a right subtree and 
                // value of the current node is less than high or 
                // minimum number in our range (it can also be called this way)
                // then there can be a value in the right subtree 
                // that can fall in the range and we need to check it
                queue.add(current.right);
                
                // ortherwise, meaning if the current value is already greater than low or 
                // equal to the high then there is no meaning of checking right subtree
            }
        }
        // at the end we have checked values of our nodes in the tree
        // and we have added all the values to our sum that fall in the range
        // so we can return the sum
        return sum;
    }
}
