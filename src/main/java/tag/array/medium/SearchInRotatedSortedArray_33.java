package tag.array.medium;

/**
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 *
 * @author zrfan
 * @date 2020/11/07.
 */
public class SearchInRotatedSortedArray_33 {

  /**
   * 很简单
   */
  public int search(int[] nums, int target) {

    int res = -1;
    for (int i = 0; i < nums.length; i++) {

      if (nums[i] == target){
        res = i;
        break;
      }

    }

    return res;
  }
}
