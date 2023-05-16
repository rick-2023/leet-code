package tag.tree.medium;

import java.util.Arrays;

/**
 * @author zrfan
 * @date 2021/07/10.
 */
public class Leetcode_105 {

  // 根据前序遍历和中序遍历的结果构建二叉树
  // 思路 递归，前序遍历，数组第 0 位为root;中序遍历的数组中 根节点所在左边为左子树， 右边为右子树。


  public TreeNode buildTree(int[] preorder, int[] inorder) {

    TreeNode root = null;
    if (preorder.length == 0) {
      return null;
    }

    int rootVal = preorder[0];
    root = new TreeNode();
    root.val = rootVal;

    int index = 0;
    for (int i = 0; i < inorder.length; i++) {
      if (inorder[i] == rootVal) {
        index = i;
      }
    }
    // 递归，

    root.left = buildTree(Arrays.copyOfRange(preorder, 1, index + 1), Arrays.copyOfRange(inorder, 0, index));
    root.right = buildTree(Arrays.copyOfRange(preorder, index + 1, preorder.length),
            Arrays.copyOfRange(inorder, index + 1, inorder.length));

    return root;

  }

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }
}
