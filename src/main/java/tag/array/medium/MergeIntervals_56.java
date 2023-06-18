package tag.array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * <p>
 * 思路
 * 1.对二维数组[l][r] 先排序一波，保证让l递增
 * 2.不断遍历目标数组，后一个如果有交集则r取两个最大的。否则加到list末尾
 * 3.list为空时intervals第一个直接add上
 *
 * @author zrfan
 * @date 2023/06/18.
 */
public class MergeIntervals_56 {

  public int[][] merge(int[][] intervals) {


    Arrays.sort(intervals, (o1, o2) -> {
      if (o1[0] == o2[0]) {
        // 若俩数组的第一个元素相等，则比较它们的第二个元素
        return o1[1] - o2[1];
      } else {
        // 若俩数组的第一个元素不相等，则按从小到大的顺序排列
        return o1[0] - o2[0];
      }
    });


    // 这里没有想到用list来包一层
    List<int[]> res = new ArrayList<>();
    for (int i = 0; i < intervals.length; i++) {

      int l = intervals[i][0], r = intervals[i][1];

      if (res.size() == 0 || res.get(res.size() - 1)[1] - l < 0) {
        res.add(new int[]{l, r});
      } else {
        res.get(res.size() - 1)[1] = Math.max(res.get(res.size() - 1)[1], r);
      }

    }

    return res.toArray(new int[res.size()][]);

  }
}
