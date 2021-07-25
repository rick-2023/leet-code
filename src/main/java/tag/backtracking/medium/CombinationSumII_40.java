package tag.backtracking.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * backtracking解决
 * <p>
 * 关键在于 help 函数要怎么写
 *
 * @author zrfan
 * @date 2021/07/25.
 */
public class CombinationSumII_40 {

  Set<List<Integer>> result = new HashSet<>();

  public List<List<Integer>> combinationSum2(int[] candidates, int target) {

    Arrays.sort(candidates);

    help(candidates, 0, target, new ArrayList());

    return new ArrayList<>(result);

  }

  private void help(int[] candidates, int start, int target, List<Integer> temp) {

    if (target < 0) {
      return;
    }

    if (target == 0) {
      result.add(new ArrayList<>(temp));
      return;
    }

    for (int i = start; i < candidates.length; i++) {

      if (candidates[i] > target) {
        return;
      }

      // 过滤重复元素
      if (i > start && candidates[i] == candidates[i - 1]) {
        continue;
      }

      temp.add(candidates[i]);
      help(candidates, i + 1, target - candidates[i], temp);
      temp.remove(temp.size() - 1);

    }

  }

  public static void main(String[] args) {
    CombinationSumII_40 combinationSumII_40 = new CombinationSumII_40();
    //[1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1]
    //30
    List<List<Integer>> lists = combinationSumII_40.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);

    System.out.println(lists);
  }
}
