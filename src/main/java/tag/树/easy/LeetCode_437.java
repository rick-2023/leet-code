package tag.树.easy;

/**
 * @author zrfan
 * @date 2020/02/01.
 */
public class LeetCode_437 {


  /**
   * 递归
   * root 左右子树 分别递归计算当前val与sum是否相等
   */

  /*public int pathSum(TreeNode root, int sum) {
    if(root == null){
      return 0;
    }
    return dfs(root,sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
  }

  public int dfs(TreeNode root, int sum){
    int count = 0;
    if(root == null){
      return 0;
    }

    if(root.val == sum){
      count++;
    }
    count += dfs(root.left, sum-root.val);
    count += dfs(root.right, sum-root.val);


    return count;
  }*/
}
