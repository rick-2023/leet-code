package tag.array.medium;

import java.util.Arrays;

/**
 * @author zrfan
 * @date 2023/08/26.
 */
public class LeetCode_2279 {

  public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {

    int len = capacity.length;
    int[] missing = new int[len];
    for (int i = 0; i < len; i++) {
      // 计算每一个背包差多少装满
      missing[i] = capacity[i] - rocks[i];
    }

    // 排序 O(nlogn)
    Arrays.sort(missing);

    int j;
    for (j = 0; j < len; j++) {

      if (additionalRocks - missing[j] >= 0) {
        additionalRocks -= missing[j];
      } else {
        break;
      }

    }

    return j;

  }
}
