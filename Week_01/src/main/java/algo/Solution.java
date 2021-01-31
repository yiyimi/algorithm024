package algo;

import algo.dataStructure.ListNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    /**
     * @Description: T(n)=O(n); S(n)=O(1).
     * @Author: yiyimi
     * @Date: 2021/1/31 0031
     */
    public static int removeDuplicates(int[] nums) {
        int len = 0;
        if (nums == null || nums.length < 1) return len;
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[j]) {
                j++;
                if (j < i + 1) {
                    nums[j] = nums[i];
                }
            }
        }
        return j+1;
    }

    /**
     * @Description: T(n)=O(n); S(n)=O(n).
     * @Author: yiyimi
     * @Date: 2021/1/31 0031
     */
    public static void rotate(int[] nums, int k) {
        int len = nums.length;
        int[] res = Arrays.copyOf(nums, len);
        for (int i = 0; i < len; i++) {
            nums[(k + i) % len] = res[i];
        }
    }

    /**
     * @Description: T(n)=O(m+n);S(n)=O(1).
     * @Author: yiyimi
     * @Date: 2021/1/31 0031
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-1);
        ListNode tmp = res;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tmp.next = l1;
                l1 = l1.next;
            } else {
                tmp.next = l2;
                l2 = l2.next;
            }
            tmp = tmp.next;
        }
        if (l1 != null) tmp.next = l1;
        if (l2 != null) tmp.next = l2;
        return res.next;
    }

    /**
     * @Description: T(n)=O(m+n); S(n)=O(m).
     * @Author: yiyimi
     * @Date: 2021/1/31 0031
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] tmp = Arrays.copyOf(nums1, m);
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < m && j < n) {
            if (tmp[i] <= nums2[j]) {
                nums1[k++] = tmp[i++];
            } else {
                nums1[k++] = nums2[j++];
            }
        }
        if (i < m) {
            System.arraycopy(tmp, i, nums1, k, m - i);
        }
        if (j < n) {
            System.arraycopy(nums2, j, nums1, k, n - j);
        }
    }

    /**
     * @Description: T(n)=O(n); S(n)=O(n).
     * @Author: yiyimi
     * @Date: 2021/1/31 0031
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (numMap.containsKey(target - nums[i])) {
                return new int[] {numMap.get(target - nums[i]), i};
            }
            numMap.put(nums[i], i);
        }
        return null;
    }

    /**
     * @Description: T(n)=O(n); S(n)=O(1).
     * @Author: yiyimi
     * @Date: 2021/1/31 0031
     */
    public static int[] moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i > j) {
                    nums[j] = nums[i];
                    nums[i] = 0;
                }
                j++;
            }
        }
        return nums;
    }

    /**
     * @Description: T(n)=O(n); S(n)=O(n).
     * @Author: yiyimi
     * @Date: 2021/1/31 0031
     */
    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            if (digits[i] % 10 > 0) {
                return digits;
            } else {
                digits[i] = 0;
            }
        }
        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = 1;
        return newDigits;
    }


}
