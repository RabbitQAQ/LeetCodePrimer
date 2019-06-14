package com.rabbit.solution.medium;

import com.rabbit.solution.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution173 {
    public static void main(String[] args) {
        BSTIterator bstIterator = new BSTIterator(null);
        System.out.println(bstIterator.next());
    }
}

class BSTIterator {
    Queue<TreeNode> queue;
    TreeNode root;

    public BSTIterator(TreeNode root) {
        queue = new LinkedList<>();
        this.root = root;
        initQueue(root);
    }

    private void initQueue(TreeNode t){
        if (t == null)
            return;
        initQueue(t.left);
        queue.offer(t);
        initQueue(t.right);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        if (hasNext())
            return queue.poll().val;
        else
            return -1;
    }
}
