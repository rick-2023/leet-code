package tag.array.medium;

/**
 * 数组装水
 *
 * @author zrfan
 * @date 2021/03/13.
 */
public class LeetCode_42 {

  public int maxArea(int[] height) {

    int N = height.length;

    if (N == 0) {
      return 0;
    }

    // 维护数组中 跟左侧最大的值，从左往右是一个递增的数组
    int[] leftMaxArr = new int[N];
    leftMaxArr[0] = height[0];
    for (int i = 1; i < N; i++) {
      leftMaxArr[i] = Math.max(leftMaxArr[i - 1], height[i]);
    }

    // 相反
    int[] rightMaxArr = new int[N];
    rightMaxArr[N - 1] = height[N - 1];
    for (int i = N - 2; i >= 0; i--) {
      rightMaxArr[i] = Math.max(rightMaxArr[i + 1], height[i]);
    }

    int sum = 0;
    for (int i = 1; i < N - 1; i++) {

      sum += Math.max(Math.min(leftMaxArr[i - 1], rightMaxArr[i + 1]) - height[i], 0);

    }

    System.out.println(sum);
    return sum;

  }

  public static void main(String[] args) {
    LeetCode_42 leetCode_42 = new LeetCode_42();
    leetCode_42.maxArea(new int[]{4,2,0,3,2,5});
  }


}
