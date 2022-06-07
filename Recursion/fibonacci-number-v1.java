// This solution uses memorization (Using Array) not to calculate a fib number twice
class Solution {
    // initializing the array where found fib numbers are stored for future use
    int[] mem = new int[31]; 
    public int fib(int n) {
        if (n == 0) { // base case #1
            return 0;
        }
        if (n == 1) { // base case #2
            return 1;
        }
        
        // if the fib number was calculated previously, no need for recalculation
        if (mem[n] != 0) { 
            return mem[n];
        }
        
        // if the fib number was NOT calculated previously, 
        // calculate it through recursive call and store it in the array
        else {
            mem[n] = fib(n - 1) + fib(n - 2); // store it
            return mem[n]; // return from where it is stored
        }       
    }
}
