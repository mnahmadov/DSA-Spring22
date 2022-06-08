// Link to the Binary Tree Postorder Traversal problem on Leetcode: https://leetcode.com/problems/binary-tree-postorder-traversal/

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
    public List<Integer> postorderTraversal(TreeNode root) {
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
            // we take the node that is on top of the stack
            root = stack.peek();
            if (root.left == null && root.right == null) {
                // we add the value of current node
                // if and only if its left and right subtrees are traversed
                // or it can also be said that its left and right children are null
                result.add(root.val);
                stack.pop(); // and we can continue with the next node on our stack
            }
            
            else {
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
                    root.right = null; // we mark this node as visited
                }

                // as explained we check if there is a left subtree
                // if there is, we push left child of our current node to our stack
                if (root.left != null) {
                    stack.add(root.left);
                    root.left = null; // we mark this node as visited
                }
            }
        }
        
        // at the end the whole tree is traversed using preorder traversal
        // we have our resulting list of values
        // and we can return it
        return result;
    }
}
