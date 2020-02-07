package tag.DP.medium;

/**
 * @author zrfan
 * @date 2020/02/07.
 */
public class LeetCode_64 {

  /*
  Input:
          [
          [1,3,1],
          [1,5,1],
          [4,2,1]
          ]
  Output: 7
  Explanation: Because the path 1→3→1→1→1 minimizes the sum.
  */

  /**
   *
   * dp[i][j] = Math.min(dp[i-1][j]+dp[i][j-1])+grid[i][j];
   *
   */

  public int minPathSum(int[][] grid) {

    // 行
    int m = grid.length;
    // 列
    int n = grid[0].length;

    int[][] dp = new int[m][n];
    dp[0][0] = grid[0][0];

    for (int i = 1; i < n; i++) {
      dp[0][i] = dp[0][i-1] + grid[0][i];
    }

    for (int j = 1; j < m; j++) {
      dp[j][0] = dp[j-1][0] + grid[j][0];
    }

    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {

        dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1])+grid[i][j];

      }

    }

    return dp[m-1][n-1];

  }

  public static void main(String[] args) {
    // 测试
    int[][] grid = {{1,3,1},{1,5,1}};

    // 2
    int m = grid.length;
    // 3
    int n = grid[0].length;
    System.out.println(m +"---"+n);

    LeetCode_64 leetCode_64 = new LeetCode_64();
    int i = leetCode_64.minPathSum(grid);

    System.out.println(i);

    //1 3 1
    //1 5 1

  }

}
