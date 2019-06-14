package com.rabbit.solution.hard;

import com.rabbit.solution.utils.TreeLinkNode;
import com.rabbit.solution.utils.TreeNode;
import com.rabbit.solution.utils.Utils;
import com.sun.tools.javac.jvm.Code;

import java.util.*;

public class Solution297 {
    public static void main(String[] args) {
        int[] tree = {1,2,3,4,5,6,7,8};
        TreeNode root = Utils.generateTree(tree);
        String serialize = Codec.serialize(root);
        System.out.println(serialize);
        TreeNode fuck = Codec.deserialize(serialize);
        System.out.println("");
//        StringBuilder s = new StringBuilder();
//        s.append("fuck");
    }
}

class Codec {
    public static String serialize(TreeNode root) {
        StringBuilder res = new StringBuilder();
        serializeR(root, res);
        return res.substring(1);
    }
    private static void serializeR(TreeNode curr, StringBuilder s) {
        if (curr == null) {
            s.append(",#");
            return;
        } else
            s.append("," + curr.val);
        serializeR(curr.left, s);
        serializeR(curr.right, s);
    }

    public static int deserializeR(TreeNode root, int cur, String[] vals) {
        root.val = Integer.parseInt(vals[cur ++]);

        if (vals[cur].equals("#")) {
            root.left = null;
            ++ cur;
        } else {
            root.left = new TreeNode(-1);
            cur = deserializeR(root.left, cur, vals);
        }

        if (vals[cur].equals("#")) {
            root.right = null;
            ++ cur;
        } else {
            root.right = new TreeNode(-1);
            cur = deserializeR(root.right, cur, vals);
        }
        return cur;
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if (data.equals("null"))
            return null;
        String[] vals = data.split(",");
        TreeNode root = new TreeNode(-1);
        deserializeR(root, 0, vals);
        return root;
    }
    }
//    // Encodes a tree to a single string.
//    public static String serialize(TreeNode root) {
//        StringBuffer str = new StringBuffer();
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//        while (!queue.isEmpty()) {
//            TreeNode currNode = queue.poll();
//            if (currNode != null) {
//                str.append(currNode.val);
//                queue.offer(currNode.left);
//                queue.offer(currNode.right);
//            } else
//                str.append("null");
//            str.append(",");
//        }
//
//        return str.toString().substring(0, str.length() - 1);
//    }
//
//    // Decodes your encoded data to tree.
//    public static TreeNode deserialize(String data) {
//        String[] nodes = data.split(",");
//        if (nodes.length == 0 || nodes[0].equals("null")) {
//            return null;
//        }
//        Queue<TreeNode> queue = new LinkedList<>();
//        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
//        queue.offer(root);
//        int i = 1;
//        while (!queue.isEmpty()) {
//            TreeNode currNode = queue.poll();
//            if (i < nodes.length) {
//                if (!nodes[i].equals("null")) {
//                    currNode.left = new TreeNode(Integer.parseInt(nodes[i]));
//                    queue.offer(currNode.left);
//                }
//            }
//
//            if (++i < nodes.length) {
//                if (!nodes[i].equals("null")) {
//                    currNode.right = new TreeNode(Integer.parseInt(nodes[i]));
//                    queue.offer(currNode.right);
//                }
//            }
//            ++i;
//        }
//
//        return root;
//    }

