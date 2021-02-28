# 学习笔记

## 使用二分查找，寻找一个半有序数组 [4, 5, 6, 7, 0, 1, 2] 中间无序的地方

- 思路
    - 单调性
    - 边界问题
    - 
- 数组的首位置left、中间位置mid、最后位置right

- 二分法的中间值mid划分的区间：一个有序，一个存在旋转点。
- nums[mid] < nums[right]，则[mid, right]有序；
- nums[mid] > nums[right]，则[left, mid]有序；