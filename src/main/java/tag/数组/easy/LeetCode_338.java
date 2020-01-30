package tag.数组.easy;

/**
 * @author zrfan
 * @date 2020/01/30.
 */
public class LeetCode_338 {

  /**
   * 计算一个数从0到N 的各个位置上二进制1的数量
   *
   * 1.Integer.bitCount(i)
   *
   * 2.一个数1的数量等于二进制左移>>1的个数 + i&1
   * if i==偶数
   *  0
   * if i==奇数
   *  1
   *
   *  代码如下
   */

  public int[] countBits(int num) {

    int[] result = new int[num+1];
    result[0] = 0;
    for(int i=1;i<result.length;i++){
      result[i] = result[i>>1] + (i&1);
    }

    return result;
  }
}
