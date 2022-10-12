package tag.slidingWindow.medium;

/**
 * Input: target = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: The subarray [4,3] has the minimal length under the problem constraint.
 *
 * @author zrfan
 * @date 2021/07/26.
 */
public class MinimumSizeSubarraySum_209 {

  public int minSubArrayLen(int target, int[] nums) {

    int left = 0, right = 0, sum = 0, min = Integer.MAX_VALUE;

    while (right < nums.length) {

      sum += nums[right];

      // 移动右指针一直到 sum 超过 or 等于 target
      while (sum >= target) {

        min = Math.min(min, right - left + 1);
        // 不断增加 left 并减掉左边的数，
        sum -= nums[left++];

      }

      right++;

    }

    return min == Integer.MAX_VALUE ? 0 : min;

  }


  public int minSubArrayLen2(int target, int[] nums) {

    int left = 0, sum = 0, result = Integer.MAX_VALUE;

    for (int right = 0; right < nums.length; right++) {

      sum += nums[right];

      while (sum >= target) {

        //  长度要再加1
        result = Math.min(result, right - left + 1);
        sum -= nums[left];
        left++;

      }


    }

    return result;
  }


  public static void main(String[] args) {
    MinimumSizeSubarraySum_209 minimumSizeSubarraySum_209 = new MinimumSizeSubarraySum_209();
    int i = minimumSizeSubarraySum_209.minSubArrayLen(4, new int[]{2, 2, 1, 4});
    int j = minimumSizeSubarraySum_209.minSubArrayLen(7, new int[]{2, 3, 2, 2, 4, 3});
    int k = minimumSizeSubarraySum_209.minSubArrayLen2(7, new int[]{2, 3, 2, 2, 4, 3});

    System.out.println(i);
    System.out.println(j);
    System.out.println(k);
  }
}
