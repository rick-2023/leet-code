package tag.slidingWindow.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Input: nums = [1,2,3,1], k = 3
 * Output: true
 * <p>
 * Input: nums = [1,2,3,1,2,3], k = 2
 * Output: false
 * <p>
 * <p>
 * Given an integer array nums and an integer k,
 * return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.
 * <p>
 * 首先看到 tag 是滑动窗口给陷进去了。。
 *
 * @author zrfan
 * @date 2021/07/27.
 */
public class ContainsDuplicateII_219 {

  public boolean containsNearbyDuplicate(int[] nums, int k) {


    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {

      if (!set.add(nums[i])) {
        return true;
      }

      if (set.size() > k) {
        set.remove(nums[i - k]);
      }

    }

    return false;


  }


  private boolean helpWithHashMap(int[] nums, int k) {


    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {

      if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
        return true;
      }

      map.put(nums[i], i);

    }

    return false;

  }

  public static void main(String[] args) {
    ContainsDuplicateII_219 containsDuplicateII_219 = new ContainsDuplicateII_219();
    boolean b = containsDuplicateII_219.helpWithHashMap(new int[]{1, 2, 3, 1}, 3);
    boolean b1 = containsDuplicateII_219.helpWithHashMap(new int[]{1, 2, 3, 1, 2, 3}, 2);

    System.out.println(b);
    System.out.println(b1);

  }
}
