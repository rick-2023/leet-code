package tag.数组.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author zrfan
 * @date 2020/10/22.
 */
public class ThreeSum_15 {

  /**
   * Input: nums = [-1,0,1,2,-1,-4]
   * Output: [[-1,-1,2],[-1,0,1]]
   * <p>
   * 思路
   * <p>
   * 1.先对数组排序
   * 2.确定一个nums[i] 比如最小nums[0]的这个, 左右夹逼之和是否等于-nums[i]
   * 3.直接用list的话不会去重，因此使用set
   */
  public List<List<Integer>> threeSum(int[] nums) {

    Set<List<Integer>> result = new HashSet<>();
    Arrays.sort(nums);

    for (int i = 0; i < nums.length - 2; i++) {

      int j = i + 1;
      int k = nums.length - 1;

      while (j < k) {

        int res = nums[i] + nums[j] + nums[k];
        if (res == 0) {

          result.add(Arrays.asList(nums[i], nums[j++], nums[k--]));

        } else if (res > 0) {

          k--;

        } else if (res < 0) {
          j++;
        }
      }
    }
    return new ArrayList<>(result);
  }
}
