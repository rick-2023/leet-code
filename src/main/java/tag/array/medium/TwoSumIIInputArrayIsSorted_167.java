package tag.array.medium;


import org.junit.Test;

import java.util.Arrays;

/**
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
 *
 * @author zrfan
 * @date 2022/10/15.
 */
public class TwoSumIIInputArrayIsSorted_167 {


  public static int[] twoSum(int[] numbers, int target) {

    int left = 0, right = numbers.length - 1;

    while (left < right){

      int temp = numbers[left] + numbers[right];
      if (temp == target) {

        return new int[]{left+1, right+1};

      } else if (temp < target) {
        left ++;
      } else if (temp > target) {
        right --;
      }

    }

    return new int[]{-1, -1};
  }

  @Test
  public void test(){

    int[] res = twoSum(new int[]{2, 7, 11, 15}, 9);
    Arrays.stream(res).forEach(i-> System.out.println(i));
  }
}
