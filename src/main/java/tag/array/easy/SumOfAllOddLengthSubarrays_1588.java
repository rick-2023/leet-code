package tag.array.easy;

/**
 * Input: arr = [1,4,2,5,3]
 * Output: 58
 * Explanation: The odd-length subarrays of arr and their sums are:
 * [1] = 1
 * [4] = 4
 * [2] = 2
 * [5] = 5
 * [3] = 3
 * [1,4,2] = 7
 * [4,2,5] = 11
 * [2,5,3] = 10
 * [1,4,2,5,3] = 15
 * If we add all these together we get 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58
 *
 * @author zrfan
 * @date 2020/11/12.
 */
public class SumOfAllOddLengthSubarrays_1588 {

  /**
   *
   * 解题思路
   * 1.计算以数组中每个数字开始或结尾的数组数量，然后相乘
   * 2.重复计算的情况 除以2 有奇数个和偶数个数组的区别
   * 3.如果结果为奇数 再加1
   * 4.数组下标对应的值乘以 第3步的结果 累计相加sum
   * @param arr
   * @return
   */
  public int sumOddLengthSubarrays(int[] arr) {

    int sum = 0;

    if (arr == null || arr.length == 0) {
      return 0;
    }

    int length = arr.length;

    for (int i = 0; i < length; i++) {

      int start = length - i;
      int end = i+1;

      int totoalArray = start * end;
      int subarray = totoalArray/2;
      if (totoalArray % 2 ==1) {
        subarray++;
      }

      sum += arr[i]*subarray;
    }



    return sum;
  }

  public static void main(String[] args) {
    int[] arr = {1,4,2,5,3};
    SumOfAllOddLengthSubarrays_1588 sumOfAllOddLengthSubarrays_1588 = new SumOfAllOddLengthSubarrays_1588();
    int i = sumOfAllOddLengthSubarrays_1588.sumOddLengthSubarrays(arr);
    System.out.println(i);
  }

}
