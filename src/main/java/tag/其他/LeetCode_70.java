package tag.其他;

/**
 * @author zrfan
 * @date 2020/01/30.
 */
public class LeetCode_70 {

  /**
   * 递归
   *
   */

  public int climbStairs(int n) {

    if(n==1||n==0){
      return 1;
    }else {
      return climbStairs(n-1) + climbStairs(n-2);
    }

  }

  /**
   * 动态规划
   */
  public int climbStairs2(int n) {


    // [0] 存储n-2 [1] 存储 n-1
    int[] array = {1,1};
    for(int i=1;i<n;i++){

      int temp = array[1];
      array[1] += array[0];
      array[0] = temp;


    }

    return array[1];


  }
}
