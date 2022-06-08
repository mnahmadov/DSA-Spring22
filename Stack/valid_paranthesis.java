// Link to the Valid Parentheses problem on Leetcode: https://leetcode.com/problems/valid-parentheses/

// Angle Brackets [], Curly Brackets {}, Paranthesis ()
// Case 1: ({}}{) Count is okay, order not really, can handle it with counter though
// Case 2: ([)] Count is okay, order not, counter cannot really help

// Takeaway: We need to remember what is the last opening 

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>(); // Initializing Empty Stack
        // Strings are not iterable in Java, they need to be converted to Character Arrays or ..
        for (char ch : s.toCharArray()) { 
            // going through the input and grabing each character at a time
            if (ch == '(' || ch == '[' || ch == '{') { // checking if it is an opening symbol
                stack.push(ch); // push it onto the stack
            }
            else if (ch == ')' && !stack.isEmpty() && stack.peek() == '(') {
                // see a closing paranthesis and all the requirements met
                stack.pop(); // pop out of the stack
            }
            else if (ch == ']' && !stack.isEmpty() && stack.peek() == '[') {
                // see a closing angle bracket and all the requirements met
                stack.pop(); // pop out of the stack
            }
            else if (ch == '}' && !stack.isEmpty() && stack.peek() == '{') {
                // see a closing curly bracket and all the requirements met
                stack.pop(); // pop out of the stack
            }
            else {
                // Example 1: {())} we see a closing but the stack is empty
                // Example 2: {()[)} we see a closing but it does not have its match
                return false;
            }
        }
        if (stack.isEmpty()){
            // Life is good!
            return true;
        }
        else {
            // Example: (()[]){
            return false;
        }
    }
}
