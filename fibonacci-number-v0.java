class Solution {
    public int fib(int n) {
        if (n == 0) { // base case #1
            return 0;
        }
        if (n == 1) { // base case #2
            return 1;
        }
        else { // otherwise make recursive calls (divide the problem into smaller problems)
            return fib(n - 1) + fib(n - 2);
        }
    }
}