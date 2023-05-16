package tag.array.medium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Input: s = "cbacdcbc"
 * Output: "acdb"
 *
 * @author zrfan
 * @date 2022/10/30.
 */
public class RemoveDuplicateLetters_316 {

  public String removeDuplicateLetters(String s) {

    int length = s.length();
    // 记录字母出现最大的下标值
    int[] lastIndex = new int[26];

    char[] chars = s.toCharArray();
    for (int i = 0; i < length; i++) {
      lastIndex[chars[i] - 'a'] = i;

    }

    Deque<Character> stack = new ArrayDeque<>();
    boolean[] visited = new boolean[26];

    for (int i = 0; i < length; i++) {

      int i1 = chars[i] - 'a';
      if (visited[i1]) {
        continue;
      }

      while (!stack.isEmpty()
              && stack.peekLast() > chars[i]
              && lastIndex[stack.peekLast()-'a'] > i) {

        Character top = stack.removeLast();
        visited[top - 'a'] = false;
      }

      stack.addLast(chars[i]);
      visited[chars[i]-'a']=true;

    }

    StringBuilder stringBuilder = new StringBuilder();
    for (Character character : stack) {
      stringBuilder.append(character);
    }

    return stringBuilder.toString();
  }


  public static void main(String[] args) {
    RemoveDuplicateLetters_316 removeDuplicateLetters_316 = new RemoveDuplicateLetters_316();
    System.out.println(removeDuplicateLetters_316.removeDuplicateLetters("cbacdcbc"));
  }
}
