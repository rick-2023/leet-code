package tag.数组.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * DFS
 *
 * 这种题型还需要多练
 *
 * @author zrfan
 * @date 2020/02/05.
 */
public class LeetCode_39 {

  /**
   * Input: candidates = [2,3,6,7], target = 7,
   * A solution set is:
   * [
   * [7],
   * [2,2,3]
   * ]
   */

  public List<List<Integer>> combinationSum(int[] candidates, int target) {

    List<List<Integer>> result = new ArrayList<>();

    Arrays.sort(candidates);

    dfs(candidates, 0, 0, result, new ArrayList<>(), target);

    return result;

  }

  public void dfs(int[] candidates, int start, int sum, List<List<Integer>> result, List<Integer> path, int target) {

    if (sum == target) {
      result.add(new ArrayList<>(path));
      return;
    }

    if (sum > target) {
      return;
    }

    for (int i = start; i < candidates.length; i++) {

      if (sum + candidates[i] > target) {
        break;
      }

      path.add(candidates[i]);

      dfs(candidates, i, sum + candidates[i], result, path, target);

      path.remove(path.size() - 1);

    }

  }


  public static void main(String[] args) {
    // 测试
    LeetCode_39 leetCode_39 = new LeetCode_39();
    int[] candidates = {2,3,6,7};
    int target = 7;

    List<List<Integer>> result = leetCode_39.combinationSum(candidates, target);

    System.out.println(result);
  }

}
