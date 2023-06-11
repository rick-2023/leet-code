package tag.array.medium;

/**
 * 1,2,3,4,5,6,7  --> 5,6,7,1,2,3,4
 *
 * 思路如下
 * step1: 7,6,5,4,3,2,1
 * step2: 5,6,7,4,3,2,1
 * step3: 5,6,7,1,2,3,4
 * @author zrfan
 * @date 2023/06/11.
 */
public class RotateArray_189 {



  public void rotate(int[] nums, int k) {

    if (nums == null || nums.length == 0) {
      return;
    }

    int n = nums.length;
    k = k % n;

    // 整个数组反转
    reverse(nums, 0, n - 1);

    // 前k个反转
    reverse(nums, 0, k - 1);

    // 后面n-k个反转
    reverse(nums, k, n - 1);

  }

  /**
   * help方法，指定反转数组范围内的值
   *
   * @param nums  数组
   * @param start 开始
   * @param end   结束
   */
  private void reverse(int[] nums, int start, int end) {

    while (start < end) {
      int temp = nums[start];
      nums[start] = nums[end];
      nums[end] = temp;
      start++;
      end--;
    }

  }

}
