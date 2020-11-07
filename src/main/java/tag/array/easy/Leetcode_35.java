package tag.array.easy;

/**
 * 35. Search Insert Position 二分法
 * @author zrfan
 * @date 2020/01/27.
 */
public class Leetcode_35 {

  public int searchInsert(int[] nums, int target) {

    int low = 0;
    int high = nums.length - 1;

    while (low <= high) {
      int mid=low+(high-low)/2;

      if (target == nums[mid]) {
        return mid;
      } else if (target < nums[mid]) {
        high = mid -1;
      } else {
        low = mid + 1;
      }

    }

    return low;
  }
}
