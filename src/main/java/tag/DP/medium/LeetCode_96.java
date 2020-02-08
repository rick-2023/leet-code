package tag.DP.medium;

/**
 * @author zrfan
 * @date 2020/02/08.
 */
public class LeetCode_96 {

  public int numTrees(int n) {

    // 0-n 共n+1位
    int[] dp = new int[n+1];

    dp[0] = 1;
    dp[1] = 1;
    for (int i = 2; i <= n; i++) {
      for (int j = 1; j <= i; j++) {
        dp[i] += dp[i-j] * dp[j-1];
      }
    }

    return dp[n];
  }

  public static void main(String[] args) {
    int n = 3;
    LeetCode_96 leetCode_96 = new LeetCode_96();
    int i = leetCode_96.numTrees(n);

    System.out.println(i);
  }
}
