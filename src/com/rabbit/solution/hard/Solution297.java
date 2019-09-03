package com.rabbit.solution.hard;

import com.rabbit.solution.utils.TreeLinkNode;
import com.rabbit.solution.utils.TreeNode;
import com.rabbit.solution.utils.Utils;
import com.sun.tools.javac.jvm.Code;

import java.util.*;

public class Solution297 {
}

class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder res = new StringBuilder();
        preOrderEncoder(root, res);
        System.out.println(res.toString());
        return res.toString();
    }

    public void preOrderEncoder(TreeNode root, StringBuilder res) {
        if (root == null) {
            res.append("# ");
            return;
        }
        res.append(String.valueOf(root.val) + " ");
        preOrderEncoder(root.left, res);
        preOrderEncoder(root.right, res);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>();
        String[] strArray = data.split(" ");
        for (int i = 0; i < strArray.length; i++) {
            queue.offer(strArray[i]);
        }
        return preOrderDecoder(queue, 0);
    }

    public TreeNode preOrderDecoder(Queue<String> queue, Integer index) {
        if (queue.isEmpty()) {
            return null;
        }
        String curr = queue.poll();
        if (curr.equals("#")) {
            return null;
        } else {
            TreeNode res = new TreeNode(Integer.valueOf(curr));
            res.left = preOrderDecoder(queue, index);
            res.right = preOrderDecoder(queue, index);
            return res;
        }
    }

}