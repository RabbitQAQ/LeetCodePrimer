package com.rabbit.solution.easy;

import com.rabbit.solution.utils.TreeNode;
import com.rabbit.solution.utils.Utils;

import java.util.HashMap;
import java.util.Map;

public class Solution437 {

    // Normal recursive
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        // starting from current node
        int self = helper(root, sum, 0);
        int left = pathSum(root.left, sum);
        int right = pathSum(root.right, sum);
        return self + left + right;
    }

    public int helper(TreeNode root, int sum, int currSum) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left, sum, currSum + root.val);
        int right = helper(root.right, sum, currSum + root.val);

        return left + right + (root.val + currSum == sum ? 1 : 0);
    }

    // Use hashmap to reduce duplicate calculation
    public int pathSum2(TreeNode root, int sum) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        return helper2(root, sum, 0, hashMap);
    }

    public int helper2(TreeNode root, int sum, int acc, Map<Integer, Integer> hashMap) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        acc += root.val;
        if (acc == sum) {
            count++;
        }
        count += hashMap.getOrDefault(acc - sum, 0);
        hashMap.put(acc, hashMap.getOrDefault(acc, 0) + 1);
        int res = count + helper2(root.left, sum, acc, hashMap) + helper2(root.right, sum, acc, hashMap);
        // dont forget
        hashMap.put(acc, hashMap.get(acc) - 1);

        return res;
    }
}
