package tag.array.easy;

/**
 * @author zrfan
 * @date 2020/10/23.
 */
public class RunningSumOf1dArray {

  /**
   * Input: nums = [1,2,3,4]
   * Output: [1,3,6,10]
   * Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4]
   *
   * 比较好理解，从第1个开始循环，每次取前面一位加上当前位当做新数组的值
   */
  public int[] runningSum(int[] nums) {
    for (int i = 1; i < nums.length; i++) {

      nums[i] += nums[i - 1];

    }

    return nums;
  }

}
