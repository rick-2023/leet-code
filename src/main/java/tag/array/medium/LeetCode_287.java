package tag.array.medium;

import java.util.Arrays;

/**
 * @author zrfan
 * @date 2020/02/06.
 */
public class LeetCode_287 {

  /**
   * Input: [1,3,4,2,2]
   * Output: 2
   *
   * 先排序 i 和 i-1 相等。。。
   * @param nums
   * @return
   */

  public int findDuplicate(int[] nums) {


    Arrays.sort(nums);
    for (int i = 1; i < nums.length; i++) {
      if (nums[i - 1] == nums[i]) {
        return nums[i];
      }
    }

    return -1;

  }
}
