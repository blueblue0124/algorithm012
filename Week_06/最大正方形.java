class Solution {
    int n,m;
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) return 0;
        n = matrix.length;
        m = matrix[0].length;
        if (m == 0) return 0;
        int maLen = 1;
        return dfs(maLen, matrix,0);
    }

    public int dfs(int maLen, char[][] matrix, int k) {
        for (int i=k; i <= n-maLen; i++) {
            for (int j=0; j <= m-maLen; j++) {
                if (judge(maLen, matrix, i, j))
                    return Math.max(maLen*maLen ,dfs(maLen+1, matrix, i));
            }
        }
        return 0;
    }

    public boolean judge(int maLen, char[][] matrix, int i,int j) {
        if (maLen == 1 && matrix[i][j]=='1') return true;
        for (int k=i; k<i+maLen; k++) {
            for (int h=j; h<j+maLen; h++) {
                if (matrix[k][h]=='0')
                    return false;
            }
        }
        return true;
    }
}