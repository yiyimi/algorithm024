# 学习笔记

## 使用二分查找，寻找一个半有序数组 [4, 5, 6, 7, 0, 1, 2] 中间无序的地方

- 思路
  - 单调性
    - 此题二分之后的两个区间,其中一个具有单调性;
    - 利用有单调性质的区间可以作为判断条件进行解题;
  - 边界问题
- 数组的首位置left、中间位置mid、最后位置right
- 二分法的中间值mid划分区间：一个有序，一个存在旋转点。
- nums[mid] < nums[right]
  - [mid, right]有序
  - target在有序区间
    - nums[mid] <= target <= nums[right]
    - left = mid
  - target在另一区间
    - right = mid
- nums[mid] > nums[right]
  - [left, mid]有序
  - target在有序区间
    - muns[left] <= target <= nums[mid]
    - right = mid
  - target在另一区间
    - left = mid

