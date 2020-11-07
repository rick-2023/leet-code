package tag.array.easy;

/**
 * @author zrfan
 * @date 2020/01/26.
 */
public class PlusOne_66 {


  public static void main(String[] args) {
    int[] digits = new int[]{9, 9, 9};
    digits = plusOne(digits);
    System.out.println(digits.length);
  }

  /**
   * 从后往前遍历数组。考虑进位的情况==9 该位置为0 如果是第一位 申请一个i+1的数组
   */
  public static int[] plusOne(int[] digits) {

    // [1,2,9] ----> [1,3,0]
    // [9,9,9] ----> [1,0,0,0]

    int length = digits.length;
    for (int i = length - 1; i >= 0; i--) {

      if (digits[i] == 9) {
        digits[i] = 0;

        if (i == 0) {

          int[] new_digits = new int[length + 1];
          new_digits[0] = 1;

          for (int j = 0; j < length; j++) {
            new_digits[j + 1] = digits[j];
          }

          return new_digits;

        }

      } else {
        digits[i] = digits[i] + 1;
        break;
      }
    }

    return digits;

  }

}
