package tag.array.diff;

import java.util.Arrays;

/**
 * @author zrfan
 * @date 2022/10/17.
 */
public class LeetCode_370 {

  public int[] getModifiedArray(int length, int[][] updates) {

    Difference difference = new Difference(new int[length]);

    for (int i = 0; i < updates.length; i++) {

        difference.add(updates[i][0], updates[i][1], updates[i][2] );

    }


    return difference.result();
  }


  public static void main(String[] args) {
    LeetCode_370 leetCode_370 = new LeetCode_370();
    int[] modifiedArray = leetCode_370.getModifiedArray(5, new int[][]{{1, 3, 2}, {2, 4, 3}, {0, 2, -2}});
    Arrays.stream(modifiedArray).forEach(System.out::println);
  }

}
