package tag.array.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入：nums = [0,1,2,4,5,7]
 * 输出：["0->2","4->5","7"]
 * <p>
 * 解释：区间范围是：
 * [0,2] --> "0->2"
 * [4,5] --> "4->5"
 * [7,7] --> "7"
 * <p>
 * <p>
 * 双指针
 *
 * @author zrfan
 * @date 2023/08/27.
 */
public class LeetCode_228 {

  public List<String> summaryRanges(int[] nums) {

    List<String> list = new ArrayList<>();
    int len = nums.length;

    int head = 0, tail = 0;

    while (tail < len) {

      if ((tail + 1 < len) && nums[tail] + 1 == nums[tail + 1]) {
        tail++;
      } else {
        if (nums[head] == nums[tail]) {
          list.add(new String(nums[head] + ""));
        } else {
          list.add(new String(nums[head] + "->" + nums[tail]));
        }

        //等价于 tail++ --> head=tail
        head = ++tail;

      }
    }

    return list;

  }
}
