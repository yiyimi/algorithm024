学习笔记

```Java
    /**
     * @Description: 最小路径和
     * T(m,n)=O(mn); S(m,n)=O(mn).
     * m:grid row.length; n:grid column.length.
     * @Author: yiyimi
     * @Date: 2021/3/9 0001
     */
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        if (grid == null || row < 1) return -1;
        int[][] dp = new int[row][col];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < col; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[row - 1][col - 1];
    }

    /**
     * @Description: 零钱兑换
     * T(n)=O(n*k); S(n)=O(k).
     * n:coins.length; k:amount value.
     * @Author: yiyimi
     * @Date: 2021/3/9 0001
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin && dp[i - coin] != amount + 1) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == amount + 1? -1: dp[amount];
    }



```
