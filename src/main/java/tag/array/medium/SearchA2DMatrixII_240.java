package tag.array.medium;

/**
 * 刚开始以为得用二分法，后面参考网上的解法想复杂了 一个循环直接 判断值大小决定 i++ 还是 j--
 * @author zrfan
 * @date 2021/07/19.
 */
public class SearchA2DMatrixII_240 {

  public boolean searchMatrix(int[][] matrix, int target) {

    int row = matrix.length;
    int col = matrix[0].length;


    int i = 0, j = col - 1;

    while (i < row && j > 0) {

      if (matrix[i][j] == target) {
        return true;
      }

      if (matrix[i][j] > target) {
        j--;
      } else {
        i++;
      }

    }

    return false;


  }

  public static void main(String[] args) {

    int[][] matrix = {{1,2,3,5}, {11,12,13,15}, {21,22,23,25}, {31,32,33,35}};

    SearchA2DMatrixII_240 searchA2DMatrixII_240 = new SearchA2DMatrixII_240();
    boolean b = searchA2DMatrixII_240.searchMatrix(matrix, 115);

    System.out.println(b);
  }
}
