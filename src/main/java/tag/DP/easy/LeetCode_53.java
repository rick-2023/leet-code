package tag.DP.easy;

/**
 * @author zrfan
 * @date 2020/02/01.
 */
public class LeetCode_53 {

  /**
   * 求最大连续子串
   * 思路
   *  动态规划。result[] 维护每一个以i结尾的数组的最大值
   *  每次循环比较当前值与历史max的最大值
   * nums[]   -2，1，-3，4，-1，2，1，-5，4
   * result[] -2，1，-2，4，3， 5，6，1， 5
   * @param nums 数组
   * @return 结果
   */
  public int maxSubArray(int[] nums) {

    int length = nums.length;
    int[] result = new int[length];
    result[0] = nums[0];
    int max = result[0];

    for(int i=1;i<length;i++){
      result[i] = result[i-1]>0 ? result[i-1]+nums[i] : nums[i];
      max=Math.max(max,result[i]);
    }

    return max;

  }
}
