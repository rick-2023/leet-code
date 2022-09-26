package tag.stack.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://labuladong.github.io/algo/2/23/66/
 * 用队列实现栈
 *
 * @author zrfan
 * @date 2022/09/26.
 */
public class LeetCode_225 {

  private Queue<Integer> queue;
  int element;

  public LeetCode_225() {
    queue = new LinkedList<>();
  }

  public void push(int x) {

    queue.offer(x);
    element = x;
  }

  public int pop() {

    int size = queue.size();
    while (size > 2) {
      queue.offer(queue.poll());
      size--;
    }

    // 为了维护element属性
    element = queue.peek();
    queue.offer(queue.poll());

    return queue.poll();

  }

  public int top() {
    return element;
  }

  public boolean empty() {
    return queue.isEmpty();
  }
}
