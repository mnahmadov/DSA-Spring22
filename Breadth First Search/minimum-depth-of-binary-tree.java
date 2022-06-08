// Link to the Minimum Depth of Binary Tree problem on Leetcode: https://leetcode.com/problems/minimum-depth-of-binary-tree/

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
    public int minDepth(TreeNode root) {
        int minDepth = 0;
        // if we do not have a tree, simply return 0
        if (root == null) {
            return minDepth;
        };
        Queue<TreeNode> queue = new LinkedList<>();
        // we have our root as we checked previously
        // we can start from the root by pusing it onto the queue
        // and we also have at least a level
        queue.add(root);
        // as long as we have a node on our queue we need to do something
        while (!queue.isEmpty()) {
            // each time when I go into this loop that means we haven't found a leaf 
            // in the previous iteration so haven't we the minDepth
            // which means I need to increment our minDepth variable
            minDepth++;
            
            // how many nodes I have currently in the current level
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.remove();
                // if we have found a leaf that means we've found our minDepth
                // and we can simply return it
                if (current.left == null & current.right == null) {
                    return minDepth;
                }
                
                // check if the current node has children, if so add them to the queue
                // to be processed in the next iteration
                if (current.left != null) {
                    queue.add(current.left);
                }
                
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
        }
        
        // the question is why do I have here a -5 which is not a correct answer
        // for any possible input?
        // even if I have here -5, the code works perfectly fine, and passes all the test cases
        // but why?
        
        // If I ignore the return statement, that gives me an error.
        // ANY IDEA :)
        return -5;
    }
}
