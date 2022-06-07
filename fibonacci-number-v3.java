// Iterative Solution
class Solution {
    public int fib(int n) {
        if (n == 0) { // base case #1
            return 0;
        }
        if (n == 1) { // base case #2
            return 1;
        }
        int value_before_N = 0;
        int value_current_N = 1;
        int value_next_N;
        
        for (int N = 2; N <= n; N++){
            value_next_N = value_before_N + value_current_N;
            // for next iteration change the values of (N-2) (N-1)
            // since N is different in the next iteration (becomes (current N) + 1)

            
            value_before_N = value_current_N; // now make the number fib(N-2) to be fib(N-1)
            value_current_N = value_next_N; // make the number fib(N)
        }
        // reached to nth fib number, return the result
        return value_current_N;
    }
}