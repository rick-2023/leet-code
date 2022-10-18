package tag.array.diff;

import java.util.Arrays;

/**
 * 差分数组最基本实现
 *
 * @author zrfan
 * @date 2022/10/17.
 */
public class Difference {

  private int[] diff;

  public Difference(int[] nums) {

    diff = new int[nums.length];
    diff[0] = nums[0];

    for (int i = 1; i < nums.length; i++) {
      diff[i] = nums[i] - nums[i - 1];
    }

  }


  public void add(int i, int j, int val) {

    diff[i] += val;

    if (j + 1 < diff.length) {
      // j+1以后的 nums都会顺延 -val
      diff[j + 1] -= val;
    }

  }


  public int[] result() {

    int[] res = new int[diff.length];
    res[0] = diff[0];
    for (int i = 1; i < diff.length; i++) {

      res[i] = diff[i] + res[i - 1];

    }

    return res;

  }

  public static void main(String[] args) {

    Difference difference = new Difference(new int[]{1, 2, 3});
    difference.add(0,2, -1);
    difference.add(0,2, 10);
    int[] result = difference.result();
    Arrays.stream(result).forEach(System.out::println);
  }

}
