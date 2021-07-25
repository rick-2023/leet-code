package tag.backtracking.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Input: nums = [1,1,2]
 * Output:
 * [[1,1,2],
 * [1,2,1],
 * [2,1,1]]
 *
 *
 * 1.boolean[] used
 * 2.hashmap 记录 被用过--
 *
 * @author zrfan
 * @date 2021/07/25.
 */
public class PermutationsII_47 {

  Set<List<Integer>> result = new HashSet<>();

  public List<List<Integer>> permuteUnique(int[] nums) {

    // 不能有重复，需要一个数组来判断这个元素是否被用过

    boolean[] used = new boolean[nums.length];
    help(nums, new ArrayList<>(), used);
    return new ArrayList<>(result);
  }

  private void help(int[] nums, List<Integer> list, boolean[] used) {

    if (list.size() == nums.length) {
      result.add(new ArrayList<>(list));
      return;
    }

    for (int i = 0; i < nums.length; i++) {

      if (used[i]) {
        continue;
      }

      list.add(nums[i]);
      used[i] = true;
      help(nums, list, used);
      used[i] = false;
      list.remove(list.size() - 1);

    }

  }

  public static void main(String[] args) {
    PermutationsII_47 permutationsII_47 = new PermutationsII_47();
    List<List<Integer>> lists = permutationsII_47.permuteUnique(new int[]{1, 1, 2});

    System.out.println(lists);
  }
}
