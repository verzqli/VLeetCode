package me.verzqli.leetcode.everyday;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import me.verzqli.leetcode.TreeNode;
import sun.reflect.generics.tree.Tree;

/**
 * 297. 二叉树的序列化与反序列化
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 * <p>
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * <p>
 * 示例:
 * <p>
 * 你可以将以下二叉树：
 * <p>
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * <p>
 * 序列化为 "[1,2,3,null,null,4,5]"
 * 提示: 这与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 * <p>
 * 说明: 不要使用类的成员 / 全局 / 静态变量来存储状态，你的序列化和反序列化算法应该是无状态的。
 */
class LeetCode20200616 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(4);
        treeNode.right = new TreeNode(5);
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = treeNode;
        System.out.println("result=: " + new LeetCode20200616().serialize(root));
        ;
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        return dfs(root, new StringBuilder()).toString();
    }

    private StringBuilder dfs(TreeNode root, StringBuilder result) {
        if (root == null) {
            result.append("null").append(",");
            return result;
        } else {
            result.append(root.val).append(",");
            dfs(root.left, result);
            dfs(root.right, result);
        }
        return result;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] node = data.split(",");
        Deque<String> queue = new ArrayDeque<>(Arrays.asList(node));
        return dfs2(queue);
    }

    private TreeNode dfs2(Deque<String> list) {
        TreeNode root;
        if (list.peekFirst().equals("null")) {
            list.pollFirst();
            return null;
        } else {
            root = new TreeNode(Integer.parseInt(list.peekFirst()));
            list.pollFirst();
            root.left = dfs2(list);
            root.right = dfs2(list);
        }
        return  root;
    }
}
