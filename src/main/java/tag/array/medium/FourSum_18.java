package tag.array.medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zrfan
 * @date 2020/10/23.
 */
public class FourSum_18 {

  /**
   * Input: nums = [1,0,-1,0,-2,2], target = 0
   * Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
   * <p>
   * 排序后 [-2,-1,0,0,1,2]
   * 双指针
   * 4sum --> 3sum --> 2sum
   *
   * target要改为long
   *
   */

  List<Integer> list = new ArrayList<>();


  public List<List<Integer>> fourSum(int[] nums, long target) {

    // 排序
    Arrays.sort(nums);

    int len = nums.length;
    List<List<Integer>> res = new ArrayList<>();

    if (len < 4) {
      return res;
    }

    // i<len-3,后面3个要留下来，所以到len-3就够了
    for (int i = 0; i < len - 3; i++) {

      if (i == 0 || nums[i] != nums[i - 1]) {

        // 同理 j<len-2
        for (int j = i + 1; j < len - 2; j++) {

          if (j == i + 1 || nums[j] != nums[j - 1]) {

            int begin = j + 1, end = len - 1;
            long newTarget = target - nums[i] - nums[j];

            while (begin < end) {

              if (nums[begin] + nums[end] == newTarget) {
                res.add(Arrays.asList(nums[i], nums[j], nums[begin], nums[end]));
                while (begin < end && nums[begin] == nums[begin + 1]) begin++;
                while (begin < end && nums[end] == nums[end - 1]) end--;

                begin++;
                end--;
              } else if (nums[begin] + nums[end] > newTarget) {
                end--;
              } else {
                begin++;
              }
            }
          }
        }
      }

    }

    return res;

  }


  @Test
  public void test(){

    FourSum_18 fourSum18 = new FourSum_18();
    List<List<Integer>> lists = fourSum18.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
    System.out.println(lists);
  }


}
