package tag.prefixSum.easy;

/**
 * @author zrfan
 * @date 2022/10/16.
 */
public class RangeSumQuery2DImmutable_304 {

  int[][] preFixSum;

  public RangeSumQuery2DImmutable_304(int[][] matrix) {

    int m = matrix.length;
    int n = matrix[0].length;

    preFixSum = new int[m + 1][n + 1];

    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        preFixSum[i][j] = preFixSum[i - 1][j] + preFixSum[i][j - 1] - preFixSum[i - 1][j - 1] + matrix[i - 1][j - 1];
      }
    }

  }

  public int sumRegion(int row1, int col1, int row2, int col2) {

    // 注意要+1
    return preFixSum[row2 + 1][col2 + 1] - preFixSum[row2 + 1][col1] - preFixSum[row1][col2+1] + preFixSum[row1][col1];

  }

  public static void main(String[] args) {

  }
}
