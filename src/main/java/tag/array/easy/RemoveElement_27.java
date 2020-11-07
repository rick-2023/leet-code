package tag.array.easy;

/**
 *
 * Input: nums = [3,2,2,3], val = 3
 * Output: 2, nums = [2,2]
 * Explanation: Your function should return length = 2, with the first two elements of nums being 2.
 * It doesn't matter what you leave beyond the returned length. For example if you return 2 with nums = [2,2,3,3] or nums = [2,3,0,0], your answer will be accepted.
 *
 * @author zrfan
 * @date 2020/11/07.
 */
public class RemoveElement_27 {

  /**
   * 一个变量用来计数0开始，遍历原数组，如果当前的值和给定值不同，就把当前值覆盖计数变量的位置，并将计数变量加1
   */
  public int removeElement(int[] nums, int val) {

    int result = 0;
    for (int i = 0; i < nums.length; i++) {

      if (val != nums[i]) {
        nums[result++] = nums[i];
      }

    }

    return result;
  }
}
