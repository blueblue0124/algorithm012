class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        
        int res = 0;
        int nrow = grid.length;
        int ncol = grid[0].length;
        for (int r = 0; r < nrow; r++) {
            for (int c = 0; c < ncol; c++) {
                if (grid[r][c] == '1') {
                    res++;
                    dfs(grid, r, c);
                }
            }
        } 
        return res;

    }
    private void dfs(char[][] grid, int r, int c) {
        if (!inGrid(grid,r,c)) return;
        if (grid[r][c] != '1') return;
        
        grid[r][c] = '2';

        dfs(grid, r, c-1);
        dfs(grid, r, c+1);
        dfs(grid, r-1, c);
        dfs(grid, r+1, c);

    }
    
    private boolean inGrid(char[][] grid, int r, int c) {
        int row = grid.length;
        int col = grid[0].length;
        if (r < 0 || r > row-1 || c < 0 || c> col-1) return false;
        return true;
    }
}