package tag.stack.easy;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author zrfan
 * @date 2020/02/02.
 */
public class LeetCode_20 {

  /**
   * 判断括号是否合法
   *  借助
   *    HashMap 维护对应匹配的括号
   *    Stack 如果map没有对应的key 往stack中push
   *
   *   若是合法的 理论上最终 stack是空的
   *
   * @param s
   * @return
   */

  public boolean isValid(String s) {

    if (s == null || "".equals(s)) {
      return true;
    }

    HashMap<Character, Character> map = new HashMap<>();
    map.put(')', '(');
    map.put(']', '[');
    map.put('}', '{');

    Stack<Character> stack = new Stack();


    for (int i = 0; i < s.length(); i++) {

      char c = s.charAt(i);

      if (map.containsKey(c)) {

        if (stack.empty() || !stack.pop().equals(map.get(c))) {
          return false;
        }

      } else {
        stack.push(c);
      }

    }

    return stack.empty();

  }
}
