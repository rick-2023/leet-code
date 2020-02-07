package tag.DP.medium;

/**
 * @author zrfan
 * @date 2020/02/07.
 */
public class LeetCode_62 {

  /**
   * 动态规划
   * dp[i][j] = dp[i-1][j] + dp[i-1][j]
   */

  public int uniquePaths(int m, int n) {

    if (m==0 || n==0){
      return 1;
    }

    int[][] dp = new int[m][n];

    for (int i = 0; i < m; i++) {
      dp[i][0] = 1;
    }

    for (int j = 0; j < n; j++) {
      dp[0][j] = 1;
    }

    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        dp[i][j] = dp[i-1][j] + dp[i][j-1];

      }
    }
    return dp[m-1][n-1];
  }

  public static void main(String[] args) {
    // 测试
    int m=7,n=3;
    LeetCode_62 leetCode_62 = new LeetCode_62();
    int i = leetCode_62.uniquePaths(m,n);

    System.out.println(i);
  }
}
