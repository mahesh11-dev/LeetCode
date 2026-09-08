class Solution {
    public int countNegatives(int[][] grid) {
       int m = grid.length;
        int n = grid[0].length;

        int i = m - 1;   
        int j = 0;       
        int count = 0;

        while (i >= 0 && j < n) {
            if (grid[i][j] < 0) {
                
                count += (n - j);
                i--;          
            } else {
                j++;          
            }
        }
        return count; 
    }
}