package tag.DP.medium;

/**
 * @author zrfan
 * @date 2021/07/16.
 */
public class TargetSum_494 {

  // [1,1,1,1,1]
  // [0,1,1,1,1]


  // 参考https://leetcode-cn.com/problems/target-sum/solution/dong-tai-gui-hua-si-kao-quan-guo-cheng-by-keepal/ 做出来的

  /**
   * 对于这种题型还是没找到诀窍
   *
   * 状态方程如下 dp[i][j] = dp[i-1][j+nums[i]]+dp[i-1][j-nums[i]]
   *
   *
   * @param nums
   * @param target
   * @return
   */

  public int findTargetSumWays(int[] nums, int target) {

    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
    }

    if (Math.abs(target) > sum) {
      return 0;
    }

    int t = 2 * sum + 1;

    // dp[i][j]=dp[i-1][j+nums[i]] +dp[i-1][j-nums[i]];
    int[][] dp = new int[nums.length][t];

    if (nums[0] == 0) {
      // +5, -5
      dp[0][sum] = 2;
    } else {
      dp[0][sum + nums[0]] = 1;
      dp[0][sum - nums[0]] = 1;
    }

    for (int i = 1; i < nums.length; i++) {

      for (int j = 0; j < t; j++) {

        int left = j - nums[i] >= 0 ? j - nums[i] : 0;
        int right = j + nums[i] < t ? j + nums[i] : 0;

        dp[i][j] = dp[i - 1][left] + dp[i - 1][right];

      }
    }

    return dp[nums.length-1][sum+target];

  }
}
