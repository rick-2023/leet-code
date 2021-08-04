package tag.其他.easy;

/**
 * @author zrfan
 * @date 2021/08/04.
 */
public class FactorialTrailingZeroes_172 {


  /**
   * 要知道 阶乘的结尾有多少个 0 要有 2*5，并且偶数都能分解出一个 2，进一步转换为能有多少个 5
   * <p>
   * 5 可以提供 1 个 5 ---> 125/5=25
   * 25 可以提供 2 个 5 ---> 125/25=3
   * 125 可以提供出 3 个 5  ---> 125/125=1
   *
   * 对于 125! 就有 25+5+1=31个 0
   *
   */


  public int trailingZeroes(int n) {

    int res = 0;
    long divisor = 5;

    while (divisor <= n) {

      res += n / divisor;

      divisor *= 5;
    }

    return res;

  }

  public static void main(String[] args) {
    FactorialTrailingZeroes_172 factorialTrailingZeroes_172 = new FactorialTrailingZeroes_172();
    int i = factorialTrailingZeroes_172.trailingZeroes(125);
    System.out.println(i);
  }
}
