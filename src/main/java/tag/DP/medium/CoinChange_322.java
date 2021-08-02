package tag.DP.medium;

import java.util.Arrays;
import java.util.Map;

/**
 * @author zrfan
 * @date 2021/08/02.
 */
public class CoinChange_322 {

  public int coinChange(int[] coins, int amount) {

    // dp存需要 amount 时的硬币数量
    int[] dp = new int[amount + 1];
    Arrays.fill(dp, amount + 1);

    dp[0] = 0;

    for (int i = 1; i < amount + 1; i++) {

      for (int coin : coins) {

        if (i >= coin) {
          // 选了 coin 就要比较跟不选时 哪个数量更小，
          dp[i] = Math.min(dp[i], dp[i - coin] + 1);
        }

      }

    }

    return dp[amount] > amount ? -1 : dp[amount];

  }

  public static void main(String[] args) {
    CoinChange_322 coinChange_322 = new CoinChange_322();
    int i = coinChange_322.coinChange(new int[]{1, 2, 5}, 11);

    System.out.println(i);
  }
}
