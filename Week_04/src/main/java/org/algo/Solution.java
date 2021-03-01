package org.algo;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {

    
    /**
     * @Description: 分发饼干
     * T(n)=O(mlogm+nlogn); S(n)=O(logm+logn).
     * @Author: yiyimi
     * @Date: 2021/2/28 0028
     */
    public int findContentChildren(int[] g, int[] s) {
        int gLen = g.length, sLen = s.length;
        int count = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        for (int i = 0, j = 0; i < gLen && j < sLen; i++, j++) {
            while (j < sLen && g[i] > s[j]) {
                j++;
            }
            if (j < sLen) {
                count++;
            }
        }
        return count;
    }

    /**
     * @Description: 买卖股票的最佳时机
     * T(n)=O(n); S(n)=O(1).
     * @Author: yiyimi
     * @Date: 2021/2/28 0028
     */
    public int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            int curr = prices[i] - prices[i - 1];
            if (curr > 0) {
                res += curr;
            }
        }
        return res;
    }

    /**
     * @Description: 找零
     * T(n)=O(n); S(n)=O(n).
     * @Author: yiyimi
     * @Date: 2021/2/28 0028
     */
    public boolean lemonadeChange(int[] bills) {
        int count5 = 0;
        int count10 = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                count5++;
            } else if (bills[i] == 10) {
                if (count5 < 1) return false;
                count5--;
                count10++;
            } else if (bills[i] == 20) {
                if (count10 > 0 && count5 > 0) {
                    count5--;
                    count10--;
                } else if (count5 > 2) {
                    count5 -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * @Description: 岛屿数量
     * T(n)=O(mn); S(n)=O(mn).
     * @Author: yiyimi
     * @Date: 2021/3/1 0001
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;
        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    ++num_islands;
                    dfs(grid, r, c);
                }
            }
        }
        return num_islands;
    }
    void dfs(char[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;
        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
            return;
        }
        grid[r][c] = '0';
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

    public int search(int[] nums, int target) {
        return -1;
    }

    /**
     * @Description: 搜索旋转排序数据
     * T(n)=O(logn); S(n)=O(1). 
     * @Author: yiyimi
     * @Date: 2021/3/1 0001
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0, right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (target == nums[mid]) return mid;
            if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target <= nums[right] && target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }


}
