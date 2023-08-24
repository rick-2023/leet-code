package tag.tree.easy;

import common.TreeNode;

import java.util.*;

/**
 * @author zrfan
 * @date 2023/08/24.
 */
public class LeetCode_102 {

  // 这里注意放到最外面来
  List<List<Integer>> res = new ArrayList<>();

  public List<List<Integer>> levelOrder(TreeNode root) {

    if (root == null) {
      return res;
    }

    if (root.left == null && root.right == null) {
      res.add(Collections.singletonList(root.val));
      return res;
    }


    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    while (!queue.isEmpty()) {

      List<Integer> tempList = new ArrayList<>();
      int size = queue.size();

      while (size-- > 0) {
        TreeNode poll = queue.poll();
        tempList.add(poll.val);

        if (poll.left != null) {
          queue.offer(poll.left);
        }

        if (poll.right != null) {
          queue.offer(poll.right);
        }
      }

      res.add(tempList);


    }


    return res;


  }
}
