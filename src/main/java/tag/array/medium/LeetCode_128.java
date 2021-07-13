package tag.array.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * 题目要求 o(n)时间复杂度，则直接忽略 sort 而是用 hashmap 空间换时间
 *
 * contains(nums[i]-1) 很关键，还需要进一步理解
 *
 * @author zrfan
 * @date 2021/07/13.
 */
public class LeetCode_128 {

  public int longestConsecutive(int[] nums) {


    if (nums.length == 0) {
      return 0;
    }


    Set<Integer> set = new HashSet<>();

    for (int i = 0; i < nums.length; i++) {
      set.add(nums[i]);
    }

    int res = 1;
    for (int i = 0; i < nums.length; i++) {

      if (set.contains(nums[i] - 1)) {
        continue;
      }

      int cs = 1;
      int temp = nums[i] + 1;

      while (set.contains(temp)) {

        cs++;
        // 连续
        temp++;

      }


      res = Math.max(res, cs);


    }

    return res;

  }

  public static void main(String[] args) {

    LeetCode_128 leetCode_128 = new LeetCode_128();
    int i = leetCode_128.longestConsecutive(new int[]{1, 200, 4, 2, 3, 2, 100});

    System.out.println(i);


  }
}
