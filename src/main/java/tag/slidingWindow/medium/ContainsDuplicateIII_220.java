package tag.slidingWindow.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;

/**
 * abs(nums[i] - nums[j]) <= t && abs(i - j) <= k.
 * <p>
 * Input: nums = [1,2,3,1], k = 3, t = 0
 * Output: true
 *
 * @author zrfan
 * @date 2021/07/28.
 */
public class ContainsDuplicateIII_220 {


  // 难上加难
  public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

    Integer[] ord = new Integer[nums.length];
    for (int i = 0; i < nums.length; i++) {
      ord[i] = i;
    }
    // 0,1,2,3
    System.out.println(ord[0]);
    // 按照 nums中大小 重新排一下
    Arrays.sort(ord, Comparator.comparingInt(a -> nums[a]));
    // 0,2,3,1
    System.out.println(ord[0]);


    for (int i = 0, j = 1; j < nums.length; ) {

      if (((long) nums[ord[j]] - nums[ord[i]]) > t) {
        i++;
        if (i == j) j++;
        continue;
      }

      int z = i;
      while (z < j) {
        if (Math.abs(ord[j] - ord[z++]) <= k) return true;
      }

      j++;
    }

    return false;
  }


  // 滑动窗口会超时-_-
  public boolean containsNearbyAlmostDuplicateV2(int[] nums, int k, int t) {

    for (int i = 0; i < nums.length; i++) {

      for (int j = i + 1; j < Math.min(i + k + 1, nums.length); j++) {

        if (Math.abs((long) nums[i] - (long) nums[j]) <= t) {
          return true;
        }

      }

    }

    return false;
  }

  public static void main(String[] args) {
    ContainsDuplicateIII_220 containsDuplicateIII_220 = new ContainsDuplicateIII_220();
    boolean b = containsDuplicateIII_220.containsNearbyAlmostDuplicate(new int[]{1, 2, 1, 1}, 1, 0);
    System.out.println(b);
    boolean b1 = containsDuplicateIII_220.containsNearbyAlmostDuplicate(new int[]{1, 5, 9, 1, 5, 9}, 2, 3);
    System.out.println(b1);
  }
}
