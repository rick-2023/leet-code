package tag.linkedList.medium;

import common.ListNode;

/**
 * Input: m = 3, n = 5, head = [3,0,2,6,8,1,7,9,4,2,5,5,0]
 * Output: [[3,0,2,6,8],[5,0,-1,-1,1],[5,2,4,9,7]]
 * Explanation: The diagram above shows how the values are printed in the matrix.
 * Note that the remaining spaces in the matrix are filled with -1.
 *
 * @author zrfan
 * @date 2023/05/19.
 */
public class SpiralMatrixIV_2326 {

  public int[][] spiralMatrix(int m, int n, ListNode head) {

    // 先把整个矩阵用-1填满
    int[][] res = new int[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        res[i][j] = -1;
      }
    }

    if (head == null) {
      return res;
    }

    int left = 0, right = n - 1, top = 0, bottom = m - 1;
    while (head != null) {

      for (int i = left; i <= right && head != null; i++) {
        res[top][i] = head.val;
        head = head.next;
      }
      top++;

      for (int i = top; i <= bottom && head != null; i++) {
        res[i][right] = head.val;
        head = head.next;
      }
      right--;

      for (int i = right; i >= left && head != null; i--) {
        res[bottom][i] = head.val;
        head = head.next;
      }
      bottom--;

      for (int i = bottom; i >= top && head != null; i--) {
        res[i][left] = head.val;
        head = head.next;
      }
      left++;
    }


    return res;
  }
}
