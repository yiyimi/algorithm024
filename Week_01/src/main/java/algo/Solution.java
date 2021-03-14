package algo;

import algo.dataStructure.ListNode;

import java.util.*;

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

    /**
     * @Description: T(n)=O(); S(n)=O().
     * @Author: yiyimi
     * @Date: 2021/1/31 0031
     */
    public static int trap(int[] height) {
        return -1;
    }

    /**
     * @Description: 4sum
     * T(n)=O(n^3); S(n)=O(n).
     * @Author: yiyimi
     * @Date: 2021/3/7 0007
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 4) return res;
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) break;
            if (nums[i] + nums[len - 3] + nums[len - 2] + nums[len - 1] < target) continue;
            for (int j = i + 1; j < len - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) break;
                if (nums[i] + nums[j] + nums[len - 2] + nums[len - 1] < target) continue;
                int left = j + 1, right = len - 1;
                int currTarget = target - nums[i] - nums[j];
                while (left < right) {
                    int curr = nums[left] + nums[right];
                    if (curr == currTarget) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[left]);
                        temp.add(nums[right]);
                        res.add(temp);
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        right--;
                    } else if (curr < currTarget) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return res;
    }

    /**
     * @Description: jump
     * T(n)=O(n); S(n)=O(1).
     * @Author: yiyimi
     * @Date: 2021/3/7 0007
     */
    public int jump(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int count = 0;
        int currStep = 0;
        int preStep = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > preStep) {
                count++;
                preStep = currStep;
            }
            if (i + nums[i] > currStep) {
                currStep = i + nums[i];
            }
        }
        return count;
    }

    public String replaceSpace(String s) {
        StringBuilder  sb = new StringBuilder();
        char[] sChar = s.toCharArray();
        for (char curr : sChar) {
            if (curr == ' ') {
                sb.append("%20");
            } else {
                sb.append(curr);
            }
        }
        return sb.toString();
    }

    public int search(int[] nums, int target) {
        int left =
    }


}
