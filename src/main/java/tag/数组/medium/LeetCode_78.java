package tag.数组.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zrfan
 * @date 2020/02/05.
 */
public class LeetCode_78 {

  /**
   * 示例
   * Input: nums = [1,2,3]
   * Output:
   * [
   *   [3],
   *   [1],
   *   [2],
   *   [1,2,3],
   *   [1,3],
   *   [2,3],
   *   [1,2],
   *   []
   * ]
   */

  /**
   *
   * 大致思路是可以理解 具体细节后面还要继续 推敲 暂时先跳过了
   * dfs思想
   *  start确保不会重复计数
   * @param nums
   * @return
   */

  public List<List<Integer>> subsets(int[] nums) {

    List<List<Integer>> result = new ArrayList<>();

    if (nums.length == 0) {
      return result;

    }

    dfs(result, new ArrayList<>(), nums, 0);

    return result;

  }


  public void dfs(List<List<Integer>> result, List<Integer> tempList, int[] nums, int start) {

    result.add(new ArrayList<>(tempList));

    for (int i = start; i < nums.length; i++) {
      tempList.add(nums[i]);
      dfs(result, tempList, nums, i + 1);
      tempList.remove(tempList.size() - 1);
    }

  }

  public static void main(String[] args) {
    // 测试
    LeetCode_78 leetCode_78 = new LeetCode_78();
    int[] nums = {1,2,3};
    List<List<Integer>> result = leetCode_78.subsets(nums);

    System.out.println(result);

  }

}
