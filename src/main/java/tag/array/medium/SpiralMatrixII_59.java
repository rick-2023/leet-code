package tag.array.medium;

import org.junit.Test;

/**
 * 给一个n=3,旋转生成一个数组 如下
 * <p>
 * 1  2  3
 * 8  9  4
 * 7  6  5
 *
 * 借助54题思路，初始index=1,一直 index++ 直到超过n^2
 *
 * @author zrfan
 * @date 2022/10/20.
 */
public class SpiralMatrixII_59 {

  public static int[][] generateMatrix(int n) {

    int[][] matrix = new int[n][n];
    int index = 1;

    int left = 0, right = n - 1, top = 0, down = n - 1;

    while (index <= n * n) {

      if (top <= down) {
        for (int i = left; i <= right; i++) {
          matrix[top][i] = index++;
        }

        top++;
      }

      // 右边界 从上到下
      if (left <= right) {

        for (int i = top; i <= down; i++) {
          matrix[i][right] = index++;
        }

        right--;


      }

      // 下边界 从右到左
      if (top <= down) {

        for (int i = right; i >= left; i--) {
          matrix[down][i] = index++;
        }

        down--;
      }

      // 左边界 从下到上
      if (left <= right) {

        for (int i = down; i >= top; i--) {
          matrix[i][left] = index++;
        }

        left++;
      }

    }

    return matrix;


  }


  @Test
  public void test(){

    int[][] matrix = generateMatrix(3);

    System.out.println(matrix);

  }

}
