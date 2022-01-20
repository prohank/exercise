package competitive.leetcode.medium;

/**
 * https://leetcode.com/problems/number-of-islands/
 * Date: 07-06-2020
 * This problem was not solved. Below answer is taken from Solutions.
 */
public class NumberofIslands {
    public int numIslands(char[][] grid) {
        if(grid == null) return 0;
        int count = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == '1'){ searchIsland(grid,i,j); count++;}
            }
        }
        return count;
    }
    public void searchIsland(char[][] grid, int i, int j){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') return;
        grid[i][j] = '0';
        searchIsland(grid,i+1,j); searchIsland(grid,i-1,j); searchIsland(grid,i,j+1); searchIsland(grid,i,j-1);
    }
}
