package tag.greddy.medium;

/**
 * 加油站
 *
 * @author zrfan
 * @date 2023/08/26.
 */
public class LeetCode_134 {


  public int canCompleteCircuit(int[] gas, int[] cost) {

    int currentSum = 0, totalSum = 0, start = 0;
    int len = gas.length;

    for (int i = 0; i < len; i++) {

      currentSum += gas[i] - cost[i];
      totalSum += gas[i] - cost[i];

      if (currentSum < 0) {
        // 复位
        currentSum = 0;
        start = i + 1;
      }
    }

    if (totalSum < 0) {
      return -1;
    }


    return start == len ? 0 : start;

  }
}
