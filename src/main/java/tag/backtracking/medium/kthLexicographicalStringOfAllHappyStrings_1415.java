package tag.backtracking.medium;

import tag.array.easy.KidsWithTheGreatestNumberOfCandies_1431;

import java.util.ArrayList;
import java.util.List;

/**
 * Input: n = 1, k = 3
 * Output: "c"
 * Explanation: The list ["a", "b", "c"] contains all happy strings of length 1. The third string is "c".
 * <p>
 * <p>
 * <p>
 * Input: n = 3, k = 9
 * Output: "cab"
 * Explanation: There are 12 different
 * happy string of length 3 ["aba", "abc", "aca", "acb", "bab", "bac", "bca", "bcb", "cab", "cac", "cba", "cbc"].
 * You will find the 9th string = "cab"
 *
 * @author zrfan
 * @date 2021/07/25.
 */
public class kthLexicographicalStringOfAllHappyStrings_1415 {

  static char[] chars = {'a', 'b', 'c'};

  List<String> result = new ArrayList<>();

  public String getHappyString(int n, int k) {

    help(n, new StringBuilder(), 0);
    return result.size() < k ? "" : result.get(k - 1);
  }

  private void help(int n, StringBuilder stringBuilder, int index) {

    if (stringBuilder.length() == n) {
      result.add(stringBuilder.toString());
      return;
    }

    for (char ch : chars) {

      // 第一次就直接加
      if (stringBuilder.length() == 0) {
        stringBuilder.append(ch);
      } else if (stringBuilder.length() > 0 && ch != stringBuilder.charAt(stringBuilder.length() - 1)) {
        stringBuilder.append(ch);
      } else {
        // 相邻
        continue;
      }

      help(n, stringBuilder, index + 1);
      stringBuilder.deleteCharAt(stringBuilder.length() - 1);

    }

  }

  public static void main(String[] args) {
    int n = 3, k = 9;

    kthLexicographicalStringOfAllHappyStrings_1415 kthLexicographicalStringOfAllHappyStrings_1415 = new kthLexicographicalStringOfAllHappyStrings_1415();

    String happyString = kthLexicographicalStringOfAllHappyStrings_1415.getHappyString(n, k);
    System.out.println(happyString);

  }


}
