package com.rabbit.solution.easy;

import com.rabbit.solution.utils.TreeNode;

import java.util.Stack;

public class Solution100 {
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        Stack<TreeNode> pStack = new Stack<>();
        Stack<TreeNode> qStack = new Stack<>();
        pStack.push(p);
        qStack.push(q);
        while (!pStack.isEmpty()) {
            if (qStack.isEmpty()) {
                return false;
            }
            TreeNode currNodeP = pStack.pop();
            TreeNode currNodeQ = qStack.pop();
            if ((currNodeP == null && currNodeQ != null) || (currNodeQ == null && currNodeP != null)) {
                return false;
            } else if (currNodeP != null && currNodeP.val != currNodeQ.val) {
                return false;
            }

            if (currNodeP != null) {
                pStack.push(currNodeP.left);
                pStack.push(currNodeP.right);
                qStack.push(currNodeQ.left);
                qStack.push(currNodeQ.right);
            }
        }

        if (!qStack.isEmpty()) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        TreeNode root00 = new TreeNode(1);
        TreeNode node01 = new TreeNode(2);

        TreeNode root01 = new TreeNode(1);
        TreeNode node12 = new TreeNode(2);

        root00.left = node01;
        root01.right = node12;

        System.out.println(isSameTree(root00, root01));

        Stack<Integer> fuckyou = new Stack<>();
        fuckyou.push(null);
        fuckyou.push(1);
        System.out.println(fuckyou.pop());
    }
}
