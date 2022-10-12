package tag.slidingWindow.medium;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Input: s1 = "ab", s2 = "eidbaooo"
 * Output: true
 * Explanation: s2 contains one permutation of s1 ("ba").
 *
 * @author zrfan
 * @date 2022/10/12.
 */
public class PermutationInString_567 {

  // s2 是否包含了 s1
  public static boolean checkInclusion(String s1, String s2) {

    int left = 0, right = 0;
    Map<Character, Integer> needs = new HashMap<>();
    Map<Character, Integer> windows = new HashMap<>();

    // {'a':1,'b':1}
    for (Character c : s1.toCharArray()) {
      needs.put(c, needs.getOrDefault(c, 0) + 1);
    }

    int valid = 0;
    char[] c = s2.toCharArray();
    while (right < s2.length()) {

      char r = c[right];
      right++;

      if (needs.containsKey(r)) {

        windows.put(r, windows.getOrDefault(r, 0) + 1);

        if (windows.get(r).equals(needs.get(r))) {
          valid++;
        }

      }

      // 完全覆盖了
      while (right - left >= s1.length()) {

        if (valid == needs.size()) {
          return true;
        }

        // 移出的字符
        char d = c[left];
        left++;

        if (needs.containsKey(d)) {

          if (needs.get(d).equals(windows.get(d))) {
            valid--;
          }
          // 这里需要注意
          windows.put(d, windows.get(d) - 1);

        }
      }
    }

    return false;

  }


  @Test
  public void test() {

    boolean b = checkInclusion("abc", "eidbaooo");
    System.out.println(b);

  }
}
