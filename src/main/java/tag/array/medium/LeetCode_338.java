package tag.array.medium;

/**
 * @author zrfan
 * @date 2020/01/20.
 */
public class LeetCode_338 {

    public static int[] countBits(int num) {
      int[] arr = new int[num + 1];
      for (int i = 0; i <= num; i++) {
        if (i % 2 == 0) {
          arr[i] = arr[i >> 1];
        } else {
          arr[i] = arr[i - 1] + 1;
        }
      }
      return arr;
    }

  public static void main(String[] args) {

      int[] arr = countBits(5);

    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }
}
