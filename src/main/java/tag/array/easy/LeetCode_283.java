package tag.array.easy;

/**
 * 将数组中0都移动到末尾
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 *
 * @author zrfan
 * @date 2022/09/27.
 */
public class LeetCode_283 {

  public static void main(String[] args) {
    LeetCode_283 leetCode_283 = new LeetCode_283();
    leetCode_283.moveZeroes(new int[] {0,1,0,3,12});
  }


  public void moveZeroes(int[] nums) {

    // {3,2,2,3} --> {2,2,2,3}
    int index = help(nums, 0);

    // 将下标index后的元素 置为0
    for (int i = index; i < nums.length; i++) {
      nums[i] = 0;
    }


  }


  public static int help(int[] nums, int val) {

    int slow=0, fast=0;
    while (fast < nums.length) {


      if (nums[fast] != val) {
        nums[slow++] = nums[fast];
      }

      fast++;

    }

    return slow;

  }


}
