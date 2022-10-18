package tag.array.diff.medium;

import org.junit.Test;

import java.util.Arrays;

/**
 *
 * tag 前缀和
 * Input: bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
 * Output: [10,55,45,25,25]
 * Explanation:
 * Flight labels:        1   2   3   4   5
 * Booking 1 reserved:  10  10
 * Booking 2 reserved:      20  20
 * Booking 3 reserved:      25  25  25  25
 * <p>
 * Total seats:         10  55  45  25  25
 * Hence, answer = [10,55,45,25,25]
 *
 * @author zrfan
 * @date 2022/10/18.
 */
public class CorporateFlightBookings_1109 {

  int[] diff;

  public int[] corpFlightBookings(int[][] bookings, int n) {

    int[] res = new int[n];
    diff = new int[n];

    int row = bookings.length;

    for (int a = 0; a < row; a++) {

      int i = bookings[a][0];
      int j = bookings[a][1];
      int k = bookings[a][2];

      // 注意 由于下标是从1开始，这里i,j要先-1
      add(i-1, j-1, k);

    }


    res[0] = diff[0];
    for (int i = 1; i < diff.length; i++) {

      res[i] = diff[i] + res[i - 1];

    }

    return res;

  }

  public void add(int i, int j, int val) {

    diff[i] += val;

    if (j + 1 < diff.length) {
      diff[j + 1] -= val;
    }

  }

  @Test
  public void test() {
    CorporateFlightBookings_1109 corporateFlightBookings_1109 = new CorporateFlightBookings_1109();
    int[] res = corporateFlightBookings_1109.corpFlightBookings(new int[][]{{1, 2, 10}, {2, 3, 20}, {2, 5, 25}}, 5);
    Arrays.stream(res).forEach(System.out::println);
  }


}
