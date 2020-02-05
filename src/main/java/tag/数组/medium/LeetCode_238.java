package tag.数组.medium;

/**
 * @author zrfan
 * @date 2020/02/05.
 */
public class LeetCode_238 {

  /**
   * 思路
   *  维护两个数组
   *  分别存储下标为i的 左边数乘积 与 右边数的乘积
   *  最后再将n1[i] * n2[i] 相乘
   * 本题参考了其他博客的思路 标注下印象更深刻
   * @param nums
   * @return
   */

  public int[] productExceptSelf(int[] nums) {

    int n = nums.length;
    int[] n1 = new int[n];
    int[] n2 = new int[n];

    n1[0]=1;
    n2[0]=1;

    for(int i=1;i<n;i++){

      n1[i] = nums[i-1] * n1[i-1];
      n2[i] = nums[n-i] * n2[i-1];
    }

    int[] result = new int[n];
    for(int i=0;i<n;i++){
      result[i] = n1[i] * n2[i];
    }

    return result;

  }
}
