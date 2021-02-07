package algo;

import algo.dataStructure.Node;
import algo.dataStructure.TreeNode;

import java.util.*;

/**
 * @author: yiyimi
 * @description: T(n)=O();S(n)=O().
 */
public class Solution {

    /**
     * @Description: isAnagram
     * T(n)=O(); S(n)=O().
     * @Author: yiyimi
     * @Date: 2021/2/7 0007
     */
    public static boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> str = new HashMap<>();
        char[] ss = s.toCharArray();
        for (char temp : ss) {
            if (!str.containsKey(temp)) {
                str.put(temp, 1);
            } else {
                str.put(temp, str.get(temp) + 1);
            }
        }
        for (char temp : t.toCharArray()) {
            if (!str.containsKey(temp)) {
                return false;
            } else if (str.get(temp) > 1){
                str.put(temp, str.get(temp) - 1);
            } else {
                str.remove(temp);
            }
        }
        return true;
    }

    /**
     * @Description: twoSum
     * T(n)=O(n); S(n)=O(n).
     * @Author: yiyimi
     * @Date: 2021/2/7 0007
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (numMap.containsKey(target - nums[i])) {
                return new int[] {numMap.get(target - nums[i]), i};
            }
            numMap.put(nums[i], i);
        }
        return null;
    }

    /**
     * @Description: twoSum
     * T(n)=O(n*n);S(n)=O(1)
     * @Author: yiyimi
     * @Date: 2021/2/7 0007
     */
    public static int[] twoSum_bak(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    List<Integer> res = new ArrayList<>();
    /**
     * @Description: preorder
     * T(n)=O(m); S(n)=O(m). m是n叉树的节点个数
     * @Author: yiyimi
     * @Date: 2021/2/7 0007
     */
    public List<Integer> preorder(Node root) {
        if (root == null) return res;
        res.add(root.val);
        for (Node node : root.children) {
            preorder(node);
        }
        return res;
    }

    /**
     * @Description: preorder
     * T(n)=O(m); S(n)=O(m). m是n叉树的节点个数
     * @Author: yiyimi
     * @Date: 2021/2/7 0007
     */
    public List<Integer> preorder_bak(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<Node> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            res.add(curr.val);
            Collections.reverse(curr.children);
            for (Node node : curr.children) {
                stack.add(node);
            }
        }
        return res;
    }

    /**
     * @Description: groupAnagrams
     * T(n)=O(nklogk); S(n)=O(nk).k为strs中字符串的最大长度.
     * @Author: yiyimi
     * @Date: 2021/2/7 0007
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> strMap = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortStr = String.valueOf(chars);
            List<String> temp = strMap.getOrDefault(sortStr, new ArrayList<>());
            temp.add(str);
            strMap.put(sortStr, temp);
        }
        return new ArrayList<List<String>>(strMap.values());
//        List<List<String>> res = new ArrayList<>();
//        strMap.forEach((k, v) -> {
//            res.add(v);
//        });
//        return res;
    }

    /**
     * @Description: inorderTraversal
     * T(n)=O(n); S(n)=O(n).
     * @Author: yiyimi
     * @Date: 2021/2/7 0007
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    private void inorder(TreeNode node, List<Integer> res) {
        if (node == null) return;
        inorder(node.left, res);
        res.add(node.val);
        inorder(node.right, res);
    }


    /**
     * @Description: preorderTraversal
     * T(n)=O(n); S(n)=O(n).
     * @Author: yiyimi
     * @Date: 2021/2/7 0007
     */
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> intList = new ArrayList<>();
        if(root == null) return intList;
        intList.add(root.val);
        List<Integer> leftList = preorderTraversal(root.left);
        if(leftList != null) {
            intList.addAll(leftList);
        }
        List<Integer> rightList = preorderTraversal(root.right);
        if(rightList != null) {
            intList.addAll(rightList);
        }
        return intList;
    }

    /**
     * @Description: preorderTraversal
     * T(n)=O(n); S(n)=O(n).
     * @Author: yiyimi
     * @Date: 2021/2/7 0007
     */
    public List<Integer> preorderTraversal_bak(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder_bak(root, res);
        return res;
    }

    private void preorder_bak(TreeNode node, List<Integer> res) {
        if (node == null) return;
        res.add(node.val);
        preorder_bak(node.left, res);
        preorder_bak(node.right, res);
    }

    /**
     * @Description: levelOrder
     * T(n)=O(n); S(n)=O(n).
     * @Author: yiyimi
     * @Date: 2021/2/7 0007
     */
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) return levelRes;
        levelNode(root, 0);
        return levelRes;
    }

    private List<List<Integer>> levelRes = new ArrayList<>();
    private void levelNode(Node node, int level) {
        if (levelRes.size() <= level) {
            levelRes.add(new ArrayList<>());
        }
        List<Integer> curr = levelRes.get(level);
        curr.add(node.val);
        levelRes.set(level, curr);
        for (Node child : node.children) {
            levelNode(child, level + 1);
        }
    }

    /**
     * @Description: nthUglyNumber
     * T(n)=O(n); S(n)=O(n).
     * @Author: yiyimi
     * @Date: 2021/2/7 0007
     */
    public static int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int a = 0, b = 0, c = 0;
        for (int i = 1; i < n; i++) {
            int xa = dp[a] * 2, xb = dp[b] * 3, xc = dp[c] * 5;
            dp[i] = Math.min(xa, Math.min(xb, xc));
            if (xa == dp[i]) {
                a++;
            }
            if (xb == dp[i]) {
                b++;
            }
            if (xc == dp[i]) {
                c++;
            }
        }
        return dp[n - 1];
    }

    /**
     * @Description: topKFrequent
     * T(n)=O(nlogk); S(n)=O(n).
     * @Author: yiyimi
     * @Date: 2021/2/7 0007
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i <nums.length; i++) {
            numMap.put(nums[i], numMap.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<int[]> minTopQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        for (Map.Entry<Integer, Integer> entry : numMap.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();
            if (minTopQueue.size() == k) {
                if (minTopQueue.peek()[1] < count) {
                    minTopQueue.poll();
                    minTopQueue.offer(new int[]{num, count});
                }
            } else {
                minTopQueue.offer(new int[]{num, count});
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = minTopQueue.poll()[0];
        }
        return res;
    }

    /**
     * @Description: climbStairs
     * T(n)=O(n);S(n)=O(1).
     * @Author: yiyimi
     * @Date: 2021/2/7 0007
     */
    public static int climbStairs(int n) {
        if (n < 3) return n;
        int dpPre1 = 1;
        int dpPre2 = 2;
        int res = 0;
        for (int i = 3; i <= n; i++) {
            res = dpPre1 + dpPre2;
            dpPre1 = dpPre2;
            dpPre2 = res;
        }
        return res;
    }

}

















