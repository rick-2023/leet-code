package tag.其他.medium;

/**
 * @author zrfan
 * @date 2021/07/04.
 */
public class DividedTowIntegers_29 {

  /**
   * eg1
   *  Input: dividend = 10, divisor = 3
   *  Output: 3
   *  Explanation: 10/3 = truncate(3.33333..) = 3.
   *
   * 思路分析
   * 1.首先不允许使用乘法，除法等运算, 那么首先想到就应该是使用二进制位运算来实现，任何一个十进制的都可以转为二进制来实现 如 3 = 2^1+2^0
   * 2.10/3 我们可以表示为 10 约等于 (3*2^1+3*2^0)+ 2^0
   * 左移n位表示 乘以n倍，且最后一个 2^0比 3 小构不成倍数可以忽略，故结果为 (2^1+2^0)=3
   *
   * @param dividend
   * @param divisor
   * @return
   */


  public int divide(int dividend, int divisor) {

    // 特殊情况
    if (dividend==Integer.MIN_VALUE && divisor==-1) {
      return Integer.MAX_VALUE;
    }

    boolean isNegative = (dividend>0 && divisor<0) || (dividend<0&&divisor>0);

    int res=0;

    long a = Math.abs((long)dividend);
    long b = Math.abs((long)divisor);

    int shift = 31;

    while(a>=b){


      while(a < b<<shift){
        shift--;
      }

      a -= b<<shift;
      res += 1<<shift;

    }


    return isNegative ? -res : res;

  }
}
