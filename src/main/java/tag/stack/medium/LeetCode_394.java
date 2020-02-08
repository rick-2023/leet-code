package tag.stack.medium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author zrfan
 * @date 2020/02/08.
 */
public class LeetCode_394 {

  /**
   * example
   * <p>
   * s = "3[a]2[bc]", return "aaabcbc".
   * s = "3[a2[c]]", return "accaccacc".
   * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
   */


  public String decodeString(String s) {

    // 存储重复次数
    Deque<Integer> timesStack = new ArrayDeque<>();

    // 需要重复的字符串
    Deque<String> previousStrStack = new ArrayDeque<>();

    // 最后的结果
    String res = "";
    // 临时变量 入栈用
    int time = 0;

    for (char c : s.toCharArray()){

      if (isNum(c)){

        time = time * 10 + Integer.parseInt(c + "");

      } else if (c == '['){

        timesStack.push(time);
        previousStrStack.push(res);

        res = "";
        time = 0;


      } else if (c==']'){

        int currentTime = timesStack.pop();
        String  previousStr = previousStrStack.pop();

        while (currentTime>0){
          previousStr += res;
          currentTime --;
        }

        res = previousStr;


      } else {
        // 普通字母
        res += c;
      }
    }


    return res;
  }


  public static void main(String[] args) {
    String s = "2[a2[x]]";
    LeetCode_394 leetCode_394=new LeetCode_394();
    String res = leetCode_394.decodeString(s);

    System.out.println(res);
  }

  private static boolean isNum(char c){
    return c>='0' && c<='9';
  }
}
