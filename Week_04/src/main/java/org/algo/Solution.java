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
     * @Description: 搜索旋转排序数据(二分)
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

        /**
     * @Description: 单词接龙(双向BFS)
     * T(n)=O(N*C^2); S(n)=O(N*C^2).
     * N:wordList.length; C:word.length.
     * @Author: yiyimi
     * @Date: 2021/3/1 0001
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int end = wordList.indexOf(endWord);
        if (end < 0) return 0;
        if (!wordList.contains(beginWord)) {
            wordList.add(beginWord);
        }
        int start = wordList.indexOf(beginWord);
        Queue<Integer> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        queue1.offer(start);
        queue2.offer(end);
        set1.add(start);
        set2.add(end);
        int count = 0;
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            count++;
            if (queue1.size() > queue2.size()) {
                Queue<Integer> tmpQue = queue1;
                queue1 = queue2;
                queue2 = tmpQue;
                Set<Integer> tmpSet = set1;
                set1 = set2;
                set2 = tmpSet;
            }
            int size = queue1.size();
            while (size > 0) {
                size--;
                String currWord = wordList.get(queue1.poll());
                for (int i = 0; i < wordList.size(); i++) {
                    if (set1.contains(i)) continue;
                    String checkWord = wordList.get(i);
                    if (!checkConvert(currWord, checkWord)) {
                        continue;
                    }
                    if (set2.contains(i)) {
                        return count + 1;
                    }
                    set1.add(i);
                    queue1.offer(i);
                }
            }
        }
        return 0;
    }

    private boolean checkConvert(String currWord, String checkWord) {
        int sameCnt = 0;
        for (int i = 0; i < currWord.length(); i++) {
            if (checkWord.charAt(i) != currWord.charAt(i)) {
                sameCnt++;
            }
            if (sameCnt > 1) return false;
        }
        return sameCnt == 1;
    }

    /**
     * @Description: 单词接龙(单向BFS)
     * T(n)=O(N*C^2); S(n)=O(N*C^2).
     * N:wordList.length; C:word.length.
     * @Author: yiyimi
     * @Date: 2021/3/1 0001
     */
    public int ladderLength_bak(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        boolean[] visited = new boolean[wordList.size()];
        int currIndex = wordList.indexOf(beginWord);
        if (currIndex > -1) {
            visited[currIndex] = true;
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int count = 0;
        while (queue.size() > 0) {
            int size = queue.size();
            count++;
            while (size > 0) {
                size--;
                String currWord = queue.poll();
                for (int i = 0; i < wordList.size(); i++) {
                    if (visited[i]) continue;
                    String checkWord = wordList.get(i);
                    if (!checkConvert(currWord, checkWord)) {
                        continue;
                    }
                    if (checkWord.equals(endWord)) {
                        return count + 1;
                    }
                    visited[i] = true;
                    queue.offer(checkWord);
                }
            }
        }
        return 0;
    }

    /**
     * @Description: 模拟行走机器人
     * T(n)=O(n+k); S(n)=O(k).
     * n:commands.length; k:obstacles.length.
     * @Author: yiyimi
     * @Date: 2021/3/1 0001
     */
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<String> obsSet = new HashSet<>();
        for (int[] obs : obstacles) {
            obsSet.add(obs[0] + ", " + obs[1]);
        }
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int x = 0, y = 0, currDir = 0, maxSquare = 0;
        for (int i = 0; i < commands.length; i++) {
            if (commands[i] == -2) {
                currDir = (currDir + 3) % 4;
            } else if (commands[i] == -1) {
                currDir = (currDir + 1) % 4;
            } else {
                int step = 0;
                while (step < commands[i]
                        && !obsSet.contains(
                            (x + dirs[currDir][0]) + ", " + (y + dirs[currDir][1]))) {
                    x += dirs[currDir][0];
                    y += dirs[currDir][1];
                    step++;
                }
                maxSquare = Math.max(maxSquare, x * x + y * y);
            }
        }
        return maxSquare;
    }



}
