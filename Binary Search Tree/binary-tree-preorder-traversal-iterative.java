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
    public List<Integer> preorderTraversal(TreeNode root) {
        // a linked-list where we store our node values
        List<Integer> result = new LinkedList<>();
    
        // a Stack to perform our traversals
        Stack<TreeNode> stack = new Stack<>();
        
        if (root == null) {
            // our base case as always
            return result;
        }
        // we push our root onto the stack
        stack.add(root);
        
        // while stack is not empty we need to do something
        while (!stack.isEmpty()) {
            root = stack.pop();
            // we first put our current node
            result.add(root.val);
            
            // remember stack has a FILO behavior
            // so we check if there is a right subtree
            // this  needs to be added onto the stack
            // before the left subtree is added
            // since stack is FILO DS and 
            // and also we need to first traverse left subtree then right subtree
            // we first push right child of current onto our stack
            // so that right subtree is traversed after the first one
            if (root.right != null) {
                stack.add(root.right);
            }
            
            // as explained we check if there is a left subtree
            // if there is, we push left child of our current node to our stack
            if (root.left != null) {
                stack.add(root.left);
            }
        }
        
        // at the end the whole tree is traversed using preorder traversal
        // we have our resulting list of values
        // and we can return it
        return result;
    }
}