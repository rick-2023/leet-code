package tag.DP.medium;

import java.util.Arrays;

/**
 * 还有点不熟悉，过两天再回顾
 *
 * @author zrfan
 * @date 2021/07/09.
 */
public class PerfectSquares_279 {

  public int numSquares(int n) {

    int[] dp = new int[n + 1];

    for (int i = 1; i <= n; i++) dp[i] = i;

    int upper = (int) Math.sqrt(n);
    for (int i = 1; i <= upper; i++) {

      // 完全平方数的 相当于使用了 1 个，等同于下方的 j*j
      dp[i * i] = 1;

    }

    dp[0]=0;

    for (int i = 2; i <= n; i++) {

      for (int j = 2; j * j < i; j++) {

        dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
      }
    }

    return dp[n];

  }


}
