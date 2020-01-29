package tag.树.easy;

import javax.swing.tree.TreeNode;

/**
 *
 * 求二叉树的直径，任意两个结点之间的最长距离
 *
 * @author zrfan
 * @date 2020/01/29.
 */
public class LeetCode_543 {

  int max=0;

  /**
   * 解题思路
   *  递归。
   *  因为不一定经过root,故遍历每一个结点的左右子树最大长度+1 作为上一结点的长度
   * @param root
   * @return
   */
  public int diameterOfBinaryTree(TreeNode root) {

    //LP(root);
    return max;


  }

  /*public int LP(common.TreeNode root){

    if (root == null) return 0;

    int left = LP(root.left);

    int right = LP(root.right);


    max = Math.max(max, left + right);
    return Math.max(left, right) + 1;

  }*/

}
