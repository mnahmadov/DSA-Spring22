class Solution {
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid == null){
            return 0; // error checking, if our grid is simply empty, return 0, meaning no island
        }
        int num_of_islands = 0; // our result, which is initially 0
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[i].length; j++){
                // traversing the grid, we are not interested in 0s, 
                // if we see a 1, then we should do something
                if (grid[i][j] == '1'){
                    num_of_islands += dfs(grid, i, j); // that something can be found down below :)/
                }
            }
        }
        return num_of_islands; // once we've traversed our grid, and did the computation
                                // we can return the result
    }
    
    public int dfs(char[][] grid, int i, int j){
        //checking we are in the grid by checing left, right, top, bottom borders of grid
        //and the value, which might be 0 which indicates the border of the current island
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0'){
            // if we are either outside of the grid or outside of the island
            return 0;
        }
        
        // else
        grid[i][j] = '0'; // make the place you are currently on, visited, so that no revisiting
        // this is btw, the most crucial thinking part of DFS (Depth-First-Search)
        // without this, we would end up having infinite loop, and ultimately stack-overflow, not good
        
        
        // visit adjacents of the current place
        dfs(grid, i - 1, j); // top
        dfs(grid, i + 1, j); // bottom
        dfs(grid, i, j - 1); // left
        dfs(grid, i, j + 1); // right
        // once we are done with the computation, meaning visited all the parts of the island
        // we can add 1 to our final result
        return 1;
    }
}