package tag.search;

/**
 * 右侧边界的二分
 *
 * @author zrfan
 * @date 2022/09/27.
 */
public class BasicBinaryRightSearch {


  public int binarySearchRight(int[] nums, int target) {

    int left = 0, right = nums.length - 1;

    while (left <= right) {

      int mid = left + (right - left) / 2;
      if (nums[mid] == target) {

        // [mid+1, right]
        left = mid + 1;

      } else if (nums[mid] > target) {

        // [left, mid-1]
        right = mid-1;

      } else if (nums[mid] < target) {

        left = mid + 1;

      }

    }

    if (left - 1 < 0) {
      return -1;
    }

    // left = mid+1  --->  mid = left-1
    return nums[left - 1] == target ? left - 1 : -1;

  }


  public static void main(String[] args) {
    BasicBinaryRightSearch basicBinaryLeftSearch = new BasicBinaryRightSearch();
    int i = basicBinaryLeftSearch.binarySearchRight(new int[]{1, 2, 2, 3, 3}, 1);
    System.out.println(i);
  }


}
