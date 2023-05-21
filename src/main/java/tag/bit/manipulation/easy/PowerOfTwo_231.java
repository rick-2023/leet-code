package tag.bit.manipulation.easy;

/**
 * @author zrfan
 * @date 2023/05/21.
 */
public class PowerOfTwo_231 {

  public boolean isPowerOfTwo(int n) {

    if(n<1) return false;

    // n为2次幂，则& n-1一定为0
    return (n & (n-1)) == 0;

  }

  /**
   * 二分法
   */
  public boolean isPowerOfTwo2(int n) {

    if(n<1) return false;

    int start=0, end = 30;
    while(start<=end) {
      int mid = start +(end-start)/2;

      int res = (int)Math.pow(2, mid);
      if(res == n){
        return true;
      }else if (res < n) {
        start = mid+1;
      } else {
        end = mid-1;
      }
    }
    return false;

  }
}
