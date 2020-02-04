package tag.其他.medium;


/**
 * @author zrfan
 * @date 2020/02/04.
 */
public class LeetCode_647 {

  int result = 0;

  public int countSubstrings(String s) {

    for (int i = 0; i < s.length(); i++) {
      // 奇数回文子串
      help(s, i, i);
      // 偶数回文子串
      help(s, i, i + 1);
    }
    return result;
  }

  public void help(String s, int left, int right) {

    while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {

      left--;
      right++;

      result++;

    }
  }

}
