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

    /**
     * @Description: 打家劫舍
     * T(n)=O(n); S(n)=O(1).
     * @Author: yiyimi
     * @Date: 2021/3/10 0001
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length < 1) return 0;
        int preSum = 0;
        int currSum = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = currSum;
            currSum = Math.max(nums[i] + preSum, currSum);
            preSum = temp;
        }
        return currSum;
    }

    /**
     * @Description: 打家劫舍II (房屋围城一圈)
     * T(n)=O(n); S(n)=O(1).
     * @Author: yiyimi
     * @Date: 2021/3/10 0001
     */
    public int robTwo(int[] nums) {
        if (nums == null || nums.length < 1) return 0;
        if (nums.length == 1) return nums[0];
        int first = rob(Arrays.copyOfRange(nums, 0, nums.length - 2));
        int last = rob(Arrays.copyOfRange(nums, 1, nums.length - 1));
        return Math.max(first, last);
    }

    /**
     * @Description: 最大正方形
     * T(m,n)=O(mn); S(m,n)=O(mn)
     * m:matrix.row.leng; n:matrix.column.length.
     * @Author: yiyimi
     * @Date: 2021/3/12 0001
     */
    public int maximalSquare(char[][] matrix) {
        int res = 0;
        if (matrix == null) return res;
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j]));
                    }
                } else {
                    dp[i][j] = 0;
                }
                res = Math.max(dp[i][j] * dp[i][j], res);
            }
        }
        return res;
    }

    /**
     * @Description: 矩形区域不超过 K 的最大数值和
     * T(m,n)=O(m^2 * n); S(m,n)=O(mn)
     * m:matrix.row.leng; n:matrix.column.length.
     * @Author: yiyimi
     * @Date: 2021/3/12 0001
     */
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int row = matrix.length;
        int col = matrix[0].length;
        int res = Integer.MIN_VALUE;
        //l: col left; r: col right.
        for (int l = 0; l < col; l++) {
            int[] rowSum = new int[row];
            for (int r = l; r < col; r++) {
                for (int i = 0; i < row; i++) {
                    rowSum[i] += matrix[i][r];
                }
                int currMax = getCurrentMax(rowSum, k);
                res = Math.max(currMax, res);
                if (res == k) return res;
            }
        }
        return res;
    }

    private int getCurrentMax(int[] rowSum, int k) {
        int curr = rowSum[0];
        int max = curr;
        for (int i = 1; i < rowSum.length; i++) {
            if (curr > 0) curr += rowSum[i];
            else curr = rowSum[i];
            if (curr > max) max = curr;
        }
        if (max <= k) return max;
        max = Integer.MIN_VALUE;
        for (int l = 0; l < rowSum.length; l++) {
            int temp = 0;
            for (int r = l; r < rowSum.length; r++) {
                temp += rowSum[r];
                if (temp > max && temp <= k) max = temp;
                if (max == k) return max;
            }
        }
        return max;
    }


```
