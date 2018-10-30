package com.rabbit.solution.medium;

import com.rabbit.solution.utils.TreeNode;

public class Solution105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode build(int[] preorder, int pLeft, int pRight, int[] inorder, int iLeft, int iRight) {
        if (pLeft > pRight || iLeft > iRight) {
            return null;
        }
        int mid = 0;
        for (mid = iLeft; mid <= iRight; mid++) {
            if (preorder[pLeft] == inorder[mid]) {
                break;
            }
        }
        TreeNode curr = new TreeNode(preorder[pLeft]);
        curr.left = build(preorder, pLeft + 1, pLeft + mid - iLeft, inorder, iLeft, mid - 1);
        curr.right = build(preorder, pLeft + mid - iLeft + 1, pRight, inorder, mid + 1, iRight);

        return curr;
    }

    public static void main(String[] args) {

    }
}
