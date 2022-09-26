package tag.stack.easy;

import java.util.Stack;

/**
 * 用栈实现队列
 *
 * @author zrfan
 * @date 2022/09/26.
 */
public class LeetCode_232 {

  private Stack<Integer> stack1;
  private Stack<Integer> stack2;

  public LeetCode_232() {

    stack1 = new Stack<>();
    stack2 = new Stack<>();

  }

  public void push(int x) {

    stack1.push(x);

  }

  public int pop() {

    // 保证stack2 非空
    peek();
    return stack2.pop();
  }

  public int peek() {

    if (stack2.isEmpty()) {
      while (!stack1.isEmpty()) {
        stack2.push(stack1.pop());
      }

    }

    return stack2.peek();
  }

  public boolean empty() {
    return stack1.isEmpty() && stack2.isEmpty();
  }
}
