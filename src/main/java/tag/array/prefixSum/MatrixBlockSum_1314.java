package tag.array.prefixSum;

/**
 * 还是有点不清楚.......
 *
 * @author zrfan
 * @date 2021/07/24.
 */
public class MatrixBlockSum_1314 {

  public static void main(String[] args) {

    int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
    };

    MatrixBlockSum_1314 matrixBlockSum_1314 = new MatrixBlockSum_1314();
    int[][] ints = matrixBlockSum_1314.matrixBlockSum(matrix, 1);

    System.out.println(ints);

  }

  public int[][] matrixBlockSum(int[][] mat, int k) {

    int[][] dp = dp(mat);

    for (int i = 0; i < mat.length; i++) {
      for (int j = 0; j < mat[0].length; j++) {

        int Rleft = Math.max(0, i - k);
        int Ctop = Math.max(0, j - k);

        int Rright = Math.min(mat.length - 1, i + k);
        int Cdown = Math.min(mat[0].length - 1, j + k);


        mat[i][j] = dp[Rright + 1][Cdown + 1] - dp[Rright + 1][Ctop] - dp[Rleft][Cdown + 1] + dp[Rleft][Ctop];

      }
    }

    return mat;
  }


  private int[][] dp(int[][] martix) {

    int row = martix.length;
    int col = martix[0].length;

    int[][] dp = new int[row + 1][col + 1];

    for (int i = 1; i <= row; i++) {

      for (int j = 1; j <= col; j++) {

        dp[i][j] = martix[i - 1][j - 1] + dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1];


      }

    }

    return dp;

  }
}
