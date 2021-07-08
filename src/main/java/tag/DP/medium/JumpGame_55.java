package tag.DP.medium;

/**
 * @author zrfan
 * @date 2021/07/08.
 */
public class JumpGame_55 {

  /**
   * 解法 1 dp 每一跳是取决于 上一跳剩余的 和 nums[i] 的最大值 如果大于 1 说明可以调到下一跳
   * dp[i] = max(dp[i-1],nums[i-1]) -1
   *
   * @param nums
   * @return
   */
  public boolean canJump(int[] nums) {

    int len = nums.length;
    int[] dp = new int[len];

    for(int i=1; i<=len-1; i++) {

      dp[i] = Math.max(dp[i-1], nums[i-1]) - 1;

      if (dp[i]< 0) {
        return false;
      }

    }

    return true;


  }

  public static void main(String[] args) {

    for (int i = 0; i < 3; i++) {
      System.out.println(i);
    }

    System.out.println("----------------");
    for (int i = 0; i < 3; ++i) {
      System.out.println(i);
    }
  }
}
