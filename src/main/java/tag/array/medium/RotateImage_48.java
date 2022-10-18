package tag.array.medium;

import org.junit.Test;

/**
 * Input: matrix = [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]]
 * <p>
 * <p>
 * Output: [
 * [7,4,1],
 * [8,5,2],
 * [9,6,3]]
 *
 * @author zrfan
 * @date 2020/11/07.
 */
public class RotateImage_48 {

  public static void rotate(int[][] matrix) {

    // 沿左上-右下 对称线 旋转
    int n = matrix.length;

    for (int i = 0; i < n; i++) {
      for (int j = i; j < n; j++) {

        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;

      }

    }

    // 反转每一行
    for (int[] each : matrix) {
      help(each);
    }


    // 输出matrix
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        System.out.print(matrix[i][j] + " ");
      }

      System.out.println();

    }


  }

  private static void help(int[] each) {

    int i = 0, j = each.length - 1;

    while (i < j) {

      int temp = each[i];
      each[i] = each[j];
      each[j] = temp;

      i++;
      j--;


    }


  }

  @Test
  public void test(){
    rotate(new int[][]{{1,2,3},{4,5,6}, {7,8,9}});
  }

}
