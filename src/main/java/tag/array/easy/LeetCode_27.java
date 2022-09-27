package tag.array.easy;

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


  public int removeElement(int[] nums, int val) {

    int slow = 0, fast = 0;

    while (fast < nums.length) {

      if (nums[fast] != val) {
        nums[slow++] = nums[fast];
      }

      fast++;

    }


    return slow;
  }

  public static void main(String[] args) {
    LeetCode_27 leetCode_27 = new LeetCode_27();
    int i = leetCode_27.removeElement(new int[]{3, 3, 2, 2, 2}, 3);
    System.out.println(i);
  }
}
