package tag.array.medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * {
 * 1,2,3
 * 4,5,6
 * 7,8,9
 * }
 * <p>
 * 思路： 暴力破解按照螺旋依次对数组做+-，多验算几次
 * }
 *
 * @author zrfan
 * @date 2021/07/08.
 */
public class SpiralMatrix_54 {

  public List<Integer> spiralOrder(int[][] matrix) {

    List<Integer> res = new ArrayList<>();
    int rowBegin = 0, colBegin = 0, rowEnd = matrix.length - 1, colEnd = matrix[0].length - 1;

    while (rowBegin <= rowEnd && colBegin <= colEnd) {


      for (int i = colBegin; i <= colEnd; i++) {
        res.add(matrix[rowBegin][i]);
      }
      rowBegin++;


      for (int i = rowBegin; i <= rowEnd; i++) {

        res.add(matrix[i][colEnd]);

      }

      colEnd--;


      // 往左 注意临界点，再往左去就重复计算了
      if (rowBegin <= rowEnd) {

        for (int i = colEnd; i >= colBegin; i--) {
          res.add(matrix[rowEnd][i]);
        }

      }
      rowEnd--;

      // 往上，注意临界点
      if (colBegin <= colEnd) {
        for (int i = rowEnd; i >= rowBegin; i--) {
          res.add(matrix[i][colBegin]);
        }
      }

      colBegin++;


    }

    return res;

  }


  public static List<Integer> spiralOrder2(int[][] matrix) {

    List<Integer> list = new ArrayList<>();
    int m = matrix.length;
    int n = matrix[0].length;

    // 逻辑 先从做向右，从上到下，从右到左，从下到上，不断锁定4个边界点
    int leftBound = 0, rightBound = n - 1, topBound = 0, downBound = m - 1;

    // 直到list填充满了, 注意这里是 小于< ，等于时结束循环
    while (list.size() < m * n) {

      if (topBound <= downBound) {
        for (int i = leftBound; i <= rightBound; i++) {
          list.add(matrix[topBound][i]);
        }
        topBound++;
      }

      // 右边界 从上到下
      if (leftBound <= rightBound) {

        for (int i = topBound; i <= downBound; i++) {
          list.add(matrix[i][rightBound]);
        }

        rightBound--;


      }

      // 下边界 从右到左
      if (topBound <= downBound) {

        for (int i = rightBound; i >= leftBound; i--) {
          list.add(matrix[downBound][i]);
        }

        downBound--;
      }

      // 左边界 从下到上
      if (leftBound <= rightBound) {

        for (int i = downBound; i >= topBound; i--) {
          list.add(matrix[i][leftBound]);
        }

        leftBound++;
      }


    }


    return list;

  }

  @Test
  public void test2(){
    int[][] m = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    List<Integer> list = spiralOrder2(m);

    System.out.println(list);
  }

  public static void main(String[] args) {
    SpiralMatrix_54 spiralMatrix_54 = new SpiralMatrix_54();
    int[][] m = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    List<Integer> integers = spiralMatrix_54.spiralOrder(m);

    System.out.println(integers);

  }
}
