package tag.array.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 示例
 *  输入[1,2,3]
 *  输出 所有的全排列
 *
 * 回溯算法 模板如下
 *
 * xxx 临界条件
 *
 * for 选择 in 选择列表:
 *
 *     # 做选择
 *     将该选择从选择列表移除
 *     路径.add(选择)
 *     backtrack(路径, 选择列表)
 *
 *     # 撤销选择
 *     路径.remove(选择)
 *     将该选择再加入选择列表
 *
 * @author zrfan
 * @date 2021/07/21.
 */
public class Permutations_46 {

  List<List<Integer>> result = new ArrayList<>();

  public List<List<Integer>> permute(int[] nums) {

    help(nums, new ArrayList<>());
    return result;

  }

  private void help(int[] nums, List<Integer> curr) {


    // 临界条件，该回去了
    if (curr.size() == nums.length) {
      // 注意这里 curr要 new一个不然还是引用，后面 remove 会把它移除完的
      result.add(new ArrayList<>(curr));
      return;
    }


    for (int i = 0; i < nums.length; i++) {


      if (curr.contains(nums[i])) {
        continue;
      }

      curr.add(nums[i]);
      help(nums, curr);
      // 撤销选择
      curr.remove(curr.size() - 1);

    }


  }




  public static void main(String[] args) {

    Permutations_46 permutations_46 = new Permutations_46();
    List<List<Integer>> permute = permutations_46.permute(new int[]{1, 2, 3});
    System.out.println(permute.size());
    System.out.println(permute);
  }
}
