package tag.array.easy;

import org.junit.Test;

/**
 * Input: nums = [3,2,2,3], val = 3
 * Output: 2, nums = [2,2,_,_]
 * Explanation: Your function should return k = 2, with the first two elements of nums being 2.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 * <p>
 * 快慢指针: 快指针去跟val比较，不一致则将这个赋值给慢指针对应下标的元素
 *
 * @author zrfan
 * @date 2020/01/28.
 */
public class LeetCode_27 {


  public static int removeElement(int[] nums, int val) {

    int slow = 0, fast = 0;

    while (fast < nums.length) {

      if (nums[fast] != val) {
        nums[slow++] = nums[fast];
      }

      fast++;

    }


    return slow;
  }


  public static int removeElement2(int[] nums, int val) {

    int slow = 0, fast = 0;

    for (int i = 0; i < nums.length; i++) {

      if (nums[fast] != val) {
        nums[slow] = nums[fast];
        slow++;
      }

      fast++;

    }

    return slow;

  }

  @Test
  public void main() {
    int i = removeElement2(new int[]{3, 2, 2, 3}, 3);
    System.out.println(i);
  }
}
