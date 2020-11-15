package tag.array.easy;

/**
 * @author zrfan
 * @date 2020/11/15.
 */
public class MatrixDiagonalSum_1572 {


  public int diagonalSum(int[][] mat) {

    int start = 0, end = mat.length - 1, sum = 0;

    while (start <= mat.length-1 && end >= 0) {

      sum += mat[start][start] + mat[start][end];

      start++;
      end--;

    }

    if (mat.length % 2 == 1) {
      sum -= mat[mat.length / 2 ][mat.length / 2 ];
    }

    return sum;
  }

  public static void main(String[] args) {

    int[][] mat = {
            {1,2,3},
            {4,5,6},
            {7,8,9}
    };

    MatrixDiagonalSum_1572 matrixDiagonalSum_1572 = new MatrixDiagonalSum_1572();
    int i = matrixDiagonalSum_1572.diagonalSum(mat);
    System.out.println(i);
  }
}
