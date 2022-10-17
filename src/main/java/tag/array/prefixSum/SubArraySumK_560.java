package tag.array.prefixSum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zrfan
 * @date 2021/07/20.
 */
public class SubArraySumK_560 {

  public int subarraySum(int[] nums, int k) {


    return method2(nums, k);
    //return method3(nums, k);

  }

  // 前缀和+哈希表
  private int method2(int[] nums, int k) {

    int temp = 0;
    int res = 0;

    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, 1);

    for (int i = 0; i < nums.length; i++) {

      temp += nums[i];

      if (map.containsKey(temp - k)) {
        res += map.get(temp - k);
      }
      map.put(temp, map.getOrDefault(temp, 0) + 1);


    }


    return res;

  }

  private int method3(int[] nums, int k) {

    int temp = 0;
    int res = 0;

    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, 1);

    for (int i = 0; i < nums.length; i++) {

      temp += nums[i];

      //if (map.containsKey(temp - k)) {
      //  res += map.get(temp - k);
      //}
      map.put(temp, map.getOrDefault(temp, 0) + 1);


    }


    return map.get(temp - k);
  }


  public static void main(String[] args) {
    SubArraySumK_560 subArraySumK_560 = new SubArraySumK_560();
    int[] arr = {0, 1, -1, 0};
    int k = 0;
    int i = subArraySumK_560.subarraySum(arr, k);

    System.out.println(i);
  }

  // 暴力解法 注意内层循环结束后要把 sum 重置一下
  private int method1(int[] nums, int k) {
    int res = 0;
    int len = nums.length;

    int sum = 0;

    for (int i = 0; i < len; i++) {

      for (int j = i; j < len; j++) {

        sum += nums[j];
        if (sum == k) {
          res++;
        }

      }

      sum = 0;

    }

    return res;
  }
}
