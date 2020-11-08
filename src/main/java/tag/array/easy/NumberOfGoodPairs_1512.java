package tag.array.easy;

import java.util.HashMap;

/**
 * Input: nums = [1,2,3,1,1,3]
 * Output: 4
 * Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed
 *
 * @author zrfan
 * @date 2020/11/08.
 */
public class NumberOfGoodPairs_1512 {

  public int numIdenticalPairs(int[] nums) {

    int res = 0;
    for (int i = 0; i < nums.length - 1; i++) {

      for (int j = i + 1; j < nums.length; j++) {

        if (nums[i] == nums[j]) {
          res++;
        }

      }

    }

    return res;
  }

  public int numIdenticalPairs2(int[] nums) {

    HashMap<Object, Integer> map = new HashMap<>();
    int res = 0;
    for (int i = 0; i <= nums.length - 1; i++) {

      int key = nums[i];
      map.put(key, map.getOrDefault(key, 0) + 1);

      res += map.get(key)-1;

    }

    return res;
  }

  public static void main(String[] args) {

    int[] nums = {1, 2, 3, 1, 1, 3};

    NumberOfGoodPairs_1512 numberOfGoodPairs_1512 = new NumberOfGoodPairs_1512();
    int i = numberOfGoodPairs_1512.numIdenticalPairs(nums);
    System.out.println(i);
  }

}
