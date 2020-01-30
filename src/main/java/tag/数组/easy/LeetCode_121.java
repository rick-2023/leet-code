package tag.数组.easy;

/**
 * @author zrfan
 * @date 2020/01/30.
 */
public class LeetCode_121 {


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
}
