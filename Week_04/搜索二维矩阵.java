class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int nrow = matrix.length;
        int ncol = matrix[0].length;
        if (target < matrix[0][0] || target > matrix[nrow-1][ncol-1]) return false;
        int left = 0;
        int right = nrow * ncol - 1;
        int mid = 0;
        while (left <= right) {
            mid  = (left + right) / 2;
            int m = mid/ncol;
            int n = mid%ncol;
            if (matrix[m][n] == target) return true;
            else {
                if (target > matrix[m][n] ) left = mid + 1;
                else right = mid - 1;
            }  
        }
        return false;
    }
}