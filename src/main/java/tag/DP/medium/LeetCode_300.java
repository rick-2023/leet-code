package tag.DP.medium;

import java.util.Arrays;

/**
 * @author zrfan
 * @date 2021/07/14.
 */
public class LeetCode_300 {


  /**
   * 典型 dp 问题，以某个数结尾，最长递增子序列
   * 注意 29 行针对 case{0,1,0,3,2,3} 如果 dp[j]+1比之前算出来的 dp[i]还要小就跳过没必要放进来
   * @param nums
   * @return
   */
  public int lengthOfLIS(int[] nums) {

    int res = 1;
    int[] dp = new int[nums.length];
    Arrays.fill(dp, 1);

    for (int i = 1; i < nums.length; i++) {
      for (int j = 0; j < i; j++) {

        if (nums[i] > nums[j]) {

          dp[i] = Math.max(dp[i], dp[j] + 1);
        }

      }

      res = Math.max(res, dp[i]);


    }

    System.out.println(res);
    return res;
  }


  public static void main(String[] args) {
    LeetCode_300 leetCode_300 = new LeetCode_300();
    leetCode_300.lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3});
    leetCode_300.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18, 102});
  }
}


