package tag.array.easy;

import org.junit.Test;

/**
 * Input: s = ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 *
 * @author zrfan
 * @date 2022/10/15.
 */
public class ReverseString_344 {

  public static void reverseString(char[] s) {

    int left = 0, right = s.length - 1;

    while (left < right) {

      char temp = s[left];
      s[left] = s[right];
      s[right] = temp;


      left++;
      right--;


    }


  }

  @Test
  public void test() {

    char[] s = new char[]{'h', 'e', 'l'};
    reverseString(s);

    for (char c : s) {
      System.out.println(c);
    }
  }
}
