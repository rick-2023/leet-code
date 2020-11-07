package tag.array.easy;

import java.util.Arrays;

/**
 * @author zrfan
 * @date 2020/02/02.
 */
public class LeetCode_581 {

  /**
   * 最短无序连续子数组
   * 拷贝一份，重排序sort()
   * 循环遍历比较a[i] b[i]
   * 记录起始不等与结尾不等的位置 start,end
   * 判断 end-start<0时 已经是有序的 return 0 即无需有待排序的子数组
   * 否则返回end-start+1; 用示例数据代入方便理解
   * <p>
   * [2,6,4,8,10,9,15]
   * [2,4,6,8,9,10,15]
   * ^        ^
   * 5-4+1 = 5
   *
   * @param nums
   * @return
   */

  public int findUnsortedSubarray(int[] nums) {

    int[] sums = nums.clone();
    Arrays.sort(sums);
    int start = nums.length, end = 0;

    for (int i = 0; i < nums.length; i++) {

      if (nums[i] != sums[i]) {
        start = Math.min(start, i);
        end = Math.max(end, i);
      }
    }

    return end - start < 0 ? 0 : end - start + 1;


  }
}
