package tag.search;

/**
 * 左侧边界的二分
 *
 * @author zrfan
 * @date 2022/09/27.
 */
public class BasicBinaryLeftSearch {


  public int binarySearchLeft(int[] nums, int target) {

    int left = 0, right = nums.length - 1;

    while (left <= right) {

      int mid = left + (right - left) / 2;
      if (nums[mid] == target) {

        // [x,y)
        right = mid - 1;

      } else if (nums[mid] > target) {

        right = mid - 1;

      } else if (nums[mid] < target) {

        left = mid + 1;

      }

    }

    // 没有一个比他大的
    if (left == nums.length) {
      return -1;
    }

    return nums[left] == target ? left : -1;

  }


  public static void main(String[] args) {
    BasicBinaryLeftSearch basicBinaryLeftSearch = new BasicBinaryLeftSearch();
    int i = basicBinaryLeftSearch.binarySearchLeft(new int[]{1, 1, 2, 2, 3}, 2);
    System.out.println(i);
  }


}
