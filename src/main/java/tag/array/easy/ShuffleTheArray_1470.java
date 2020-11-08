package tag.array.easy;

/**
 * Input: nums = [2,5,1,3,4,7], n = 3
 * Output: [2,3,5,4,1,7]
 * Explanation: Since x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 then the answer is [2,3,5,4,1,7]
 *
 * @author zrfan
 * @date 2020/11/08.
 */
public class ShuffleTheArray_1470 {

  /**
   * 重新构造一个新的数组，用快慢2个指针分别填充，慢指针填充i，快指针填充i+n
   * @param nums
   * @param n
   * @return
   */
  public int[] shuffle(int[] nums, int n) {

    int[] res = new int[nums.length];

    for (int i = 0, index = 0; i < n; i++, index += 2) {
      res[index] = nums[i];
      res[index+1] = nums[i + n];
    }


    return res;
  }

}
