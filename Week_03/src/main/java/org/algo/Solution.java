package org.algo;

import sun.reflect.generics.tree.Tree;

import java.util.*;

public class Solution {

    //region week03 homework.

    /**
     * @Description: 最小公共祖先(后序遍历dfs.)
     * T(n)=O(n); S(n)=O(N).
     * @Author: yiyimi
     * @Date: 2021/2/17 0017
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) return root;
        root.left = lowestCommonAncestor(root.left, p, q);
        root.right = lowestCommonAncestor(root.right, p, q);
        if (root.left == null) return root.right;
        if (root.right == null) return root.left;
        return root;
    }

    /**
     * @Description: 根据前序、中序序列构造二叉树
     * T(n)=O(n); S(n)=O(n).
     * @Author: yiyimi
     * @Date: 2021/2/16 0016
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = inorder.length;
        for (int i = 0; i < len; i++) {
            inorderMap.put(inorder[i], i);
        }
        return build(preorder, 0, len - 1, inorder, 0, len - 1);
    }

    private Map<Integer, Integer> inorderMap = new HashMap<>();
    private TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }
        int midIndex = inorderMap.get(preorder[preStart]);
        TreeNode root = new TreeNode(preorder[preStart]);
        int leftLen = midIndex - inStart;
//        int rightLen = inEnd = midIndex;
        root.left = build(preorder, preStart + 1, preStart + leftLen, inorder, inStart, midIndex - 1);
        root.right = build(preorder, preStart + leftLen + 1, preEnd, inorder, midIndex + 1, inEnd);
        return root;
    }

    public List<List<Integer>> combine(int n, int k) {
        List<Integer> curr = new ArrayList<>();
        comb(n, k, 1, curr);
        return comList;
    }

    private List<List<Integer>> comList = new ArrayList<>();
    private void comb(int n, int k, int val, List<Integer> curr) {
        if (val > n) return;
        if (curr.size() == k) {
            comList.add(new ArrayList<Integer>(curr));
            return;
        }
        comb(n, k, val + 1, new ArrayList<Integer>(curr));
        curr.add(val);
        comb(n, k, val + 1, new ArrayList<Integer>(curr));
    }


    /**
     * @author: yiyimi
     * date: 2021.2.22 11:02
     * @description: 全排列
     */
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        if (len == 0) return permute1Res;

        boolean[] status = new boolean[len];
        Deque<Integer> temp = new ArrayDeque<>();
        permute(nums, len, 0, status, temp);
        return permute1Res;
    }

    List<List<Integer>> permute1Res = new ArrayList<>();
    private void permute(int[] nums, int len, int curr, boolean[] status, Deque<Integer> temp) {
        if (curr == len) {
            permute1Res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (!status[i]) {
                temp.addLast(nums[i]);
                status[i] = true;
                permute(nums, len, curr + 1, status, temp);

                status[i] = false;
                temp.removeLast();
            }
        }
    }
    /**
     * @author: yiyimi
     * date: 2021.2.22 14:02
     * @description: 全排列
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        int len = nums.length;
        if (len == 0) return permute2Res;
        Deque<Integer> temp = new ArrayDeque<>(len);
        Arrays.sort(nums);
        boolean[] status = new boolean[len];
        permuteUnique(nums, len, 0, status, temp);
        return permute2Res;
    }

    List<List<Integer>> permute2Res = new ArrayList<>();
    private void permuteUnique(int[] nums, int len, int curr, boolean[] status, Deque<Integer> temp) {
        if (curr == len) {
            permute2Res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (status[i]) continue;
            if (i > 0 && nums[i] == nums[i - 1] && !status[i - 1]) continue;
            temp.addLast(nums[i]);
            status[i] = true;
            permuteUnique(nums, len, curr + 1, status, temp);
            temp.removeLast();
            status[i] = false;
        }
    }

    /**
     * @Description: 层序遍历bfs
     * T(n)=O(n); S(n)=O(n).
     * @Author: yiyimi
     * @Date: 2021/2/22 0016
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> levelNode = new LinkedList<>();
        levelNode.offer(root);
        while (!levelNode.isEmpty()) {
            List<Integer> curr = new ArrayList<>();
            int len = levelNode.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = levelNode.poll();
                curr.add(node.val);
                if (node.left != null) {
                    levelNode.offer(node.left);
                }
                if (node.right != null) {
                    levelNode.offer(node.right);
                }
            }
            res.add(curr);
        }
        return res;
    }

    //endregion


    /**
     * @Description: 括号生成
     * T(n)=O((4^n)/square(n)); S(n)=O(n).
     * @Author: yiyimi
     * @Date: 2021/2/16 0016
     */
    public List<String> generateParenthesis(int n) {
        generate(0, 0, n, "");
        return thesisList;
    }

    List<String> thesisList = new ArrayList<>();
    private void generate(int left, int right, int n, String str) {
        if (left == n && right == n) {
            thesisList.add(str);
            return;
        }
        if (left < n) {
            generate(left + 1, right, n, str + "(");
        }
        if (left > right) {
            generate(left, right + 1, n, str + ")");
        }
    }

    public double myPow(double x, int n) {
        if (n >= 0) {
            return calc(x, n);
        } else {
            return 1.0 / calc(x, -n);
        }
    }

    private double calc(double x, long n) {
        double res = 1.0;
        if (n < 1) {
            return res;
        }
        double temp = calc(x, n / 2);
        if (n % 2 == 1) {
            res = temp * temp * x;
        } else {
            res = temp * temp;
        }
        return res;
    }

    public List<List<Integer>> subsets(int[] nums) {
        return null;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1) return false;
        int rowLen = matrix[0].length;
        int colLen = matrix.length;
        int left = 0, right = rowLen * colLen - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (matrix[mid / rowLen][mid % rowLen] == target) {
                return true;
            } else if (matrix[mid / rowLen][mid % rowLen] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

}
