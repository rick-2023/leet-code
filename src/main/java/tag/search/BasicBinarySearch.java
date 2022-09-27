package tag.search;

/**
 * 最最最基础的二分，找到返回下标，找不到返回-1
 *
 * @author zrfan
 * @date 2022/09/27.
 */
public class BasicBinarySearch {


  public int binarySearch(int[] nums, int target) {

    if (nums == null || nums.length == 0) {
      return -1;
    }

    int left = 0, right = nums.length - 1;

    while (left <= right) {

      int mid = left + (right - left) / 2;

      if (nums[mid] == target) {
        return mid;
      } else if (nums[mid] > target) {
        right = mid - 1;
      } else if (nums[mid] < target) {
        left = mid + 1;
      }

    }

    return -1;

  }


  public static void main(String[] args) {
    BasicBinarySearch basicBinarySearch = new BasicBinarySearch();
    int i = basicBinarySearch.binarySearch(new int[]{1, 2, 3, 4, 5}, 4);

    System.out.println(i);
  }


}
