package tag.stack.medium;

import org.junit.Test;

import java.util.Stack;

/**
 * Input: num = "1432219", k = 3
 * Output: "1219"
 * Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
 *
 * 1.单调栈
 * 2.k=length 结果恒等于"0"
 * 3.结果若0开始，需要把多余的0去掉
 * 4.所有位数都一样的，需要k--    -->  pop
 *
 * @author zrfan
 * @date 2022/10/30.
 */
public class RemoveKDigits_402 {

  public static String removeKdigits(String num, int k) {

    Stack<Integer> stack = new Stack<>();
    int length = num.length();
    //char[] charArray = num.toCharArray();

    // 长度=k,即所有元素去掉
    if (k == length) {
      return "0";
    }

    for (int i = 0; i < length; i++) {

      // 这里不能写，否则循环完，栈会多一位出来
      //if (stack.isEmpty()) {
      //  stack.push(num.charAt(i) - '0');
      //}

      while (!stack.isEmpty()
              && k > 0
              && stack.peek() > num.charAt(i) - '0') {

        stack.pop();
        k--;

      }


      stack.push(num.charAt(i) - '0');

    }

    // like "111"
    while (k > 0) {
      stack.pop();
      k--;
    }

    StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()) {
      sb.append(stack.pop());
    }

    sb.reverse();

    // 去除0开头的情况
    while (sb.length() > 1 && sb.charAt(0) == '0') {
      sb.deleteCharAt(0);
    }

    return sb.toString();
  }




  @Test
  public void test() {

    String s = removeKdigits("1432219", 3);
    System.out.println(s);

    String s1 = removeKdigits("10200", 1);
    System.out.println(s1);

    String s2 = removeKdigits("10", 2);
    System.out.println(s2);


    String s3 = removeKdigits("112", 1);
    System.out.println(s3);
  }
}
