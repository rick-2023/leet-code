package tag.array.medium;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * {
 *   1,2,3
 *   4,5,6
 *   7,8,9
 *   }
 *
 *   思路： 暴力破解按照螺旋依次对数组做+-，多验算几次
 * }
 * @author zrfan
 * @date 2021/07/08.
 */
public class SpiralMatrix_54 {

  public List<Integer> spiralOrder(int[][] matrix) {

    List<Integer> res = new ArrayList<>();
    int rowBegin = 0, colBegin = 0, rowEnd = matrix.length-1, colEnd = matrix[0].length-1;

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

        for (int i = colEnd; i >=colBegin ; i--) {
          res.add(matrix[rowEnd][i]);
        }

      }
      rowEnd--;

      // 往上，注意临界点
      if (colBegin<=colEnd) {
        for (int i = rowEnd; i >= rowBegin ; i--) {
          res.add(matrix[i][colBegin]);
        }
      }

      colBegin++;


    }

    return res;

  }

  public static void main(String[] args) {
    SpiralMatrix_54 spiralMatrix_54 = new SpiralMatrix_54();
    int[][] m = {{1,2,3},{4,5,6},{7,8,9}};
    List<Integer> integers = spiralMatrix_54.spiralOrder(m);

    System.out.println(integers);

  }
}
