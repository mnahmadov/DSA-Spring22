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
    public List<List<Integer>> levelOrder(TreeNode root) {
        // declaration of the array list where we will have our nodes
        List<List<Integer>> result = new ArrayList<>();
        // if we do not have a tree, simply return the empty array list
        if (root == null) {
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        // we have our root as we checked previously
        // we can start from the root by pusing it onto the queue
        queue.add(root);
        // as long as we have a node on our queue we need to do something
        while (!queue.isEmpty()) {
            // how many nodes I have currently
            int size = queue.size();
            // add all the nodes that we have in current level to an array list
            List<Integer> currentLevel = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.remove();
                currentLevel.add(current.val);
                // check if the current node has children, if so add them to the queue
                // to be processed in the next iteration
                if (current.left != null) {
                    queue.add(current.left);
                }
                
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
            // once we have all the values in our current level, we can add them to our result
            result.add(currentLevel);
        }
        // once we have processed all the levels (our queue is empty)
        // we can return the result
        return result;
    }
}
