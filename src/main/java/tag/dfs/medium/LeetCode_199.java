package tag.dfs.medium;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author zrfan
 * @date 2021/07/12.
 */
public class LeetCode_199 {

  /**
   * Definition for a binary tree node.
   * public class TreeNode {
   * int val;
   * TreeNode left;
   * TreeNode right;
   * TreeNode() {}
   * TreeNode(int val) { this.val = val; }
   * TreeNode(int val, TreeNode left, TreeNode right) {
   * this.val = val;
   * this.left = left;
   * this.right = right;
   * }
   * }
   */

  int depth = 0;
  List<Integer> ans = new ArrayList<>();

  public List<Integer> rightSideVieDFS(TreeNode root) {

    // dfs 的终止条件
    if (root == null) {
      return ans;
    }

    depth++;
    if (ans.size() < depth) {
      ans.add(root.val);
    }

    ans = rightSideVieDFS(root.right);
    ans = rightSideVieDFS(root.left);

    // 关键点。这一层遍历完需要返回上一层
    depth--;

    return ans;

  }


  public List<Integer> rightSideViewBFS(TreeNode root) {

    List<Integer> res = new ArrayList<>();

    if (root == null) {
      return res;
    }

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    queue.add(null);

    while (queue.size() != 0) {

      TreeNode cur = queue.remove();

      if (cur == null) {

        if (queue.size() == 0) {
          break;
        }

        queue.add(null);

      } else {

        if (queue.peek() == null) {
          res.add(cur.val);
        }

        if (cur.left != null) {
          queue.add(cur.left);
        }

        if (cur.right != null) {
          queue.add(cur.right);
        }

      }

    }

    return res;

  }
}
