package tag.DP.medium;

/**
 * 背包问题 不够熟练，先完成=_=
 * @author zrfan
 * @date 2021/07/18.
 */
public class PartitionEqualSubsetSum_416 {


  public static boolean canPartition(int[] nums) {

    int sum = 0;
    for (int num : nums) {
      sum += num;
    }

    // 如果 sum 为奇数 就不能分成 2份了
    if (sum % 2 != 0) {
      return false;
    }

    int target = sum / 2;

    boolean[] dp = new boolean[target + 1];
    dp[0] = true;
    for (int num : nums) {

      for (int i = target; i >= num; i--) {

        if (i>=num){

          // 第 i位选或者不选 都行
          dp[i] = dp[i] || dp[i - num];
        }

      }

    }

    return dp[target];

  }


  public static void main(String[] args) {
    int[] arr = {1, 5, 11, 5};
    boolean b = canPartition(arr);

    System.out.println(b);

  }


}
