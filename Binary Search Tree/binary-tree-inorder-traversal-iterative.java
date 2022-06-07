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
    public List<Integer> inorderTraversal(TreeNode root) {
        // a linked-list where we store our node values
        List<Integer> result = new LinkedList<>();
        // we make use of a stack instead of recursion
        // where we continue pushing left nodes until 
        // we reach to an end
        Stack<TreeNode> stack = new Stack<>();
        // while stack is not empty we need to do something
        // or initially we have a node
        while (root != null || !stack.isEmpty()) { 
            while (root != null) {
                // this is where we push left nodes
                // until we reach to an end
                stack.add(root);
                root = root.left;
            }
            root = stack.pop();
            // we take the value of current node 
            // and put onto our resulting LinkedList
            result.add(root.val);
            // now we can continue with its right
            root = root.right;
        }
        return result;
    }
    
}
