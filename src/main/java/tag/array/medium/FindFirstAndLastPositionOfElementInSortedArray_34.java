package tag.array.medium;

/**
 * Example 1:
 * <p>
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 * <p>
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 * Example 3:
 * <p>
 * Input: nums = [], target = 0
 * Output: [-1,-1]
 *
 *
 * 二分法解决。最优
 *
 * @author zrfan
 * @date 2020/11/07.
 */
public class FindFirstAndLastPositionOfElementInSortedArray_34 {

  public int[] searchRange(int[] nums, int target) {

    int[] res = {-1,-1};
    // 左侧搜索区间
    res[0] = findFirst(nums, target);
    // 右侧搜索区间
    res[1] = findLast(nums, target);
    return res;
  }



  public int findFirst(int[] nums, int target) {

    int idx = -1;
    int start = 0;
    int end = nums.length - 1;

    while (start <= end) {
      int mid = (start + end) / 2;
      if (nums[mid] >= target) {
        end = mid - 1;
      } else {
        start = mid + 1;
      }

      if (nums[mid] == target) {
        idx = mid;
      }
    }

    return idx;
  }

  public int findLast(int[] nums, int target) {

    int idx = -1;
    int start = 0;
    int end = nums.length - 1;

    while (start <= end) {
      int mid = (start + end) / 2;
      if (nums[mid] <= target) {
        start = mid + 1;
      } else {
        end = mid + -1;
      }

      if (nums[mid] == target) {
        idx = mid;
      }
    }
    return idx;

  }


  private int[] method1(int[] nums, int target) {
    int[] res = new int[]{-1, -1};
    boolean left = true;

    for (int i = 0; i < nums.length; i++) {

      if (nums[i] == target) {
        if (left) {
          res[0] = i;
          left = false;
        }

        res[1] = i;
      }


    }

    return res;
  }

}
