// Link to the Fibonacci Number problem on Leetcode: https://leetcode.com/problems/fibonacci-number/

// This solution uses memorization (Using HashMap) not to calculate a fib number twice
class Solution {
    HashMap<Integer, Integer> mem = new HashMap<>();
    public int fib(int n) {
        if (n == 0) { // base case #1
            return 0;
        }
        if (n == 1) { // base case #2
            return 1;
        }
        // if the fib number was calculated previously, no need for recalculation
        if(mem.containsKey(n)) {
            return mem.get(n); // just get the fib number from hashmap
        }
        // if the fib number was NOT calculated previously, 
        // calculate it through recursive call and store it in hashmap
        int result = fib(n - 1) + fib(n - 2);
        mem.put(n, result); // store it into the hasmap for future use
        return result; // return what you have calculated
    }
}
