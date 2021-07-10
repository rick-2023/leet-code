package tag.dfs.medium;

/**
 * @author zrfan
 * @date 2021/07/09.
 *
 *
 * 岛屿的数量
 *
 * 解题思路 深度搜索优先 DFS
 * Input: grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * Output: 1
 */
public class NumberOfIslands_200 {

  int m, n;

  public int numIslands(char[][] grid) {

    m = grid.length; // row
    n = grid[0].length; //col

    int res = 0;

    for (int i = 0; i <= m - 1; i++) {
      for (int j = 0; j <= n - 1; j++) {

        if (grid[i][j] == '1') {
          res++;
          dfs(grid, i, j);
        }

      }

    }

    return res;
  }

  public void dfs(char[][] grid, int i, int j) {

    // 如果越界或者 搜索到的位置为 0 了就跳过
    if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == '0') {
      return;
    }

    grid[i][j] = '0';

    // 上下左右都为 1 的都置为 0
    dfs(grid, i - 1, j);
    dfs(grid, i + 1, j);
    dfs(grid, i, j - 1);
    dfs(grid, i, j + 1);


  }
}
