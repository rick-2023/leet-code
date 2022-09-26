package tag.stack.easy;

import java.util.Stack;

/**
 * https://labuladong.github.io/algo/2/23/66/
 * 用栈实现队列
 *
 * 像这种情况，可以说它们的最坏时间复杂度是 O(N)，因为包含 while 循环，可能需要从 s1 往 s2 搬移元素。
 * 但是它们的均摊时间复杂度是 O(1)，这个要这么理解：对于一个元素，最多只可能被搬运一次，也就是说 peek 操作平均到每个元素的时间复杂度是 O(1)。
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
