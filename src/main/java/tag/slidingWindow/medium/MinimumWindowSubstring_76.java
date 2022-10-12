package tag.slidingWindow.medium;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
 *
 * @author zrfan
 * @date 2022/10/11.
 */
public class MinimumWindowSubstring_76 {

  public static String minWindow(String s, String t) {

    int left = 0, right = 0;
    Map<Character, Integer> needs = new HashMap<>();
    Map<Character, Integer> windows = new HashMap<>();

    // {'a':1,'b':1,'c':1}
    for (Character c : t.toCharArray()) {
      needs.put(c, needs.getOrDefault(c, 0) + 1);
    }

    int valid = 0;
    int start = 0, len = Integer.MAX_VALUE;
    char[] c = s.toCharArray();
    while (right < s.length()) {

      char r = c[right];
      right++;

      if (needs.containsKey(r)) {

        windows.put(r, windows.getOrDefault(r, 0) + 1);

        if (windows.get(r).equals(needs.get(r))) {
          valid++;
        }

      }

      // 完全覆盖了
      while (valid == needs.size()) {

        if (right - left < len) {
          start = left;
          len = right - left;
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


    return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
  }


  @Test
  public void test() {

    String s = minWindow("ADOBECODEBANC", "ABC");
    System.out.println(s);

    String s1 = minWindow("a", "aa");
    System.out.println(s1);


    String s2 = minWindow("a", "a");
    System.out.println(s2);

    String s3 = minWindow("ab", "b");
    System.out.println(s3);
  }

}
