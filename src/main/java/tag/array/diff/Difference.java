package tag.array.diff;

import java.util.Arrays;

/**
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


  private void add(int i, int j, int val) {

    diff[i] += val;

    if (j + 1 < diff.length) {
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
