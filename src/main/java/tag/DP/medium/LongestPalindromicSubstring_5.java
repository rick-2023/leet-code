package tag.DP.medium;

import org.junit.Test;

/**
 * 给定字符串，返回最长的回文子串
 * <p>
 * 首先考虑用动态规划 三步走
 * 1.状态容器定义，一般是一维或二维数组
 * 2.初始化 比如本题对角线都置为 true
 * 3.建立状态转移方程，本地为 dp[i][j] = dp[i+1][j-1]; 取决于最里面的
 *
 *
 * 解法二 左右指针
 *
 * @author zrfan
 * @date 2021/07/06.
 */
public class LongestPalindromicSubstring_5 {

  public String longestPalindrome(String s) {

    int len = s.length();

    if (len <= 1) {
      return s;
    }

    boolean dp[][] = new boolean[len][len];

    // 初始化对角线的都是回文

    for (int i = 0; i < len; i++) {
      dp[i][i] = true;
    }

    // max必定有个长度为 1 的回文串
    int max = 1, start = 0;
    char[] chars = s.toCharArray();

    // j>0&&j<len;  i<len-1;i<j

    for (int j = 1; j < len; j++) {
      for (int i = 0; i < j && i < len - 1; i++) {

        if (chars[i] != chars[j]) {
          dp[i][j] = false;
        } else {

          if (j - i < 3) {
            dp[i][j] = true;
          } else {
            dp[i][j] = dp[i + 1][j - 1];
          }

          if (dp[i][j] && j - i + 1 > max) {
            max = j - i + 1;
            start = i;
          }


        }


      }

    }

    return s.substring(start, start + max);
  }


  // 从中间到两端扩散的双指针
  public static String longestPalindrome2(String s) {

    String res = "";
    for (int i = 0; i < s.length(); i++) {

      String s1 = help(s, i, i);
      String s2 = help(s, i, i + 1);

      res = res.length() > s1.length() ? res : s1;
      res = res.length() > s2.length() ? res : s2;

    }

    return res;

  }

  public static String help(String s, int l, int r) {

    while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
      l--;
      r++;
    }

    return s.substring(l + 1, r);

  }


  @Test
  public void test(){

    String res = longestPalindrome2("abbc");
    System.out.println(res);


  }
}
