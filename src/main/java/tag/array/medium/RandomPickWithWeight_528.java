package tag.array.medium;

import java.util.Random;

/**
 * 带权重
 *
 * 前缀和+二分搜索，二分貌似又忘记了
 * @author zrfan
 * @date 2022/10/24.
 */
public class RandomPickWithWeight_528 {

  int[] preSum;
  private Random rand = new Random();


  public RandomPickWithWeight_528(int[] w) {


    int n = w.length;
    preSum = new int[n + 1];
    preSum[0] = 0;

    for (int i = 1; i <= n; i++) {

      preSum[i] = preSum[i - 1] + w[i - 1];

    }

  }

  public int pickIndex() {

    int n = preSum.length;
    int target = rand.nextInt(preSum[n - 1]) + 1;

    return search(preSum, target) - 1;

  }


  private int search(int[] preSum, int target) {

    if (preSum.length == 0) {

      return -1;
    }

    int left = 0, right = preSum.length;

    while (left < right) {

      int mid = left + (right - left) / 2;

      if (target == preSum[mid]) {

        return mid;

      } else if (target > preSum[mid]) {

        left = mid + 1;

      } else if (target < preSum[mid]) {

        right = mid;
      }

    }

    return left;

  }
}
