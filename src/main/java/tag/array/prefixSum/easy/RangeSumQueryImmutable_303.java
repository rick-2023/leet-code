package tag.array.prefixSum.easy;

/**
 * @author zrfan
 * @date 2022/10/16.
 */
public class RangeSumQueryImmutable_303 {

  int[] preSum;

  public RangeSumQueryImmutable_303(int[] nums) {

    preSum = new int[nums.length + 1];
    preSum[0] = 0;

    for (int i = 1; i < preSum.length; i++) {
      preSum[i] = preSum[i - 1] + nums[i - 1];
    }

  }

  public int sumRange(int left, int right) {

    return preSum[right + 1] - preSum[left];
  }


  public static void main(String[] args) {
    RangeSumQueryImmutable_303 rangeSumQueryImmutable_303 = new RangeSumQueryImmutable_303(new int[]{2, 4, -1, 3});
    int i = rangeSumQueryImmutable_303.sumRange(0, 3);
    System.out.println(i);

  }
}
