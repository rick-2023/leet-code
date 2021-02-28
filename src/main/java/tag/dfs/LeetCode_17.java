package tag.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zrfan
 * @date 2021/02/28.
 */
public class LeetCode_17 {

  String[] keys = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

  public List<String> letterCombinations(String digits) {


    List<String> result = new ArrayList<>();
    StringBuilder stringBuilder = new StringBuilder();

    if (digits.length() == 0) {

      return result;
    }

    dfs(digits, 0, stringBuilder, result);

    return result;


  }

  private void dfs(String digits, int index, StringBuilder stringBuilder, List<String> result) {

    // 没有下一层的 dfs了
    if (index == digits.length()) {
      result.add(stringBuilder.toString());
      return;
    }

    String letters = keys[digits.charAt(index) - '0'];

    for (int i = 0; i < letters.length(); i++) {

      char c = letters.charAt(i);
      stringBuilder.append(c);
      dfs(digits, index + 1, stringBuilder, result);

      // 一层的 dfs结束后要将 sb 归位
      stringBuilder.deleteCharAt(stringBuilder.length() - 1);

    }

  }

  /**
   * 测试代码
   * @param args
   */
  public static void main(String[] args) {
    LeetCode_17 leetCode_17 = new LeetCode_17();
    List<String> strings = leetCode_17.letterCombinations("23");
    System.out.println(strings);
  }

}
