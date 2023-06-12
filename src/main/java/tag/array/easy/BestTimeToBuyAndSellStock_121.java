package tag.array.easy;

/**
 * @author zrfan
 * @date 2020/01/30.
 */
public class BestTimeToBuyAndSellStock_121 {


  /**
   * 股票抛售
   *  一个临时变量遍历数组记录 数组最小值
   *  每次用当前值price减去买入的最小值 与上次结果 取 max
   * @param prices
   * @return
   */
  public int maxProfit(int[] prices) {

    int res=0, buy=Integer.MAX_VALUE;

    for(int price: prices){
      buy = Math.min(buy,price);
      res = Math.max(res, price - buy);

    }
    return res;
  }

  // 动态规划
  public int maxProfit2(int[] prices) {

    int len = prices.length;
    // dp[i][0]持有股票拥有的现金, dp[i][1]不持有股票拥有的现金
    int[][] dp = new int[len][2];

    dp[0][0] = -prices[0];
    dp[0][1] = 0;

    for(int i=1; i< len;i++) {

      // i-1就持有 和 第i天才买入
      dp[i][0] = Math.max(dp[i-1][0], -prices[i]);
      // i-1天没有持有 和 i-1天持有并在第i天卖出了
      dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0]+ prices[i]);

    }

    // 最后不持有股票（都变现了）拥有的现金肯定要更多一些
    return dp[len-1][1];
  }
}
