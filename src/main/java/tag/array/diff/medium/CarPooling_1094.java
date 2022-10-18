package tag.array.diff.medium;

import org.junit.Test;

/**
 * Input: trips = [[2,1,5],[3,3,7]], capacity = 4
 * Output: false
 *
 * @author zrfan
 * @date 2022/10/18.
 */
public class CarPooling_1094 {

  int[] diff;

  public boolean carPooling(int[][] trips, int capacity) {

    diff = new int[1001];
    int row = trips.length;

    for (int k = 0; k < row; k++) {

      int val = trips[k][0];
      int i = trips[k][1];
      int j = trips[k][2];

      add(i, j - 1, val);

    }

    int[] res = new int[diff.length];
    res[0] = diff[0];

    if (res[0] > capacity) {
      return false;
    }

    for (int i = 1; i < diff.length; i++) {
      res[i] = diff[i] + res[i - 1];

      if (res[i] > capacity) {
        return false;
      }

    }

    return true;

  }


  public void add(int i, int j, int val) {

    diff[i] += val;

    if (j + 1 < diff.length) {
      diff[j + 1] -= val;
    }

  }

  @Test
  public void test() {
    CarPooling_1094 carPooling_1094 = new CarPooling_1094();
    boolean b = carPooling_1094.carPooling(new int[][]{{2, 1, 5}, {3, 3, 7}}, 4);
    System.out.println(b);
  }
}
