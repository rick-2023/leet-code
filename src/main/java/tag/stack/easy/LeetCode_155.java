package tag.stack.easy;

import java.util.Stack;

/**
 * @author zrfan
 * @date 2020/02/02.
 */
public class LeetCode_155 {


  /**
   * 最小栈
   *  定义2个栈stack,minStack 分别存储正常的元素与最小值
   *  每次push时判断需要是否需要往minStack存入值
   *  pop时判断是否需要将minStack进行pop
   */

  private Stack<Integer> stack;
  private Stack<Integer> minStack;


  /** initialize your data structure here. */
  public LeetCode_155() {
    stack = new Stack();
    minStack = new Stack();
  }

  public void push(int x) {

    if(minStack.isEmpty() || x <= minStack.peek()){
      minStack.push(x);
    }

    stack.push(x);

  }

  public void pop() {
    if(stack.peek().equals(minStack.peek())){
      minStack.pop();
    }

    stack.pop();
  }

  public int top() {
    return stack.peek();
  }

  public int getMin() {

    return minStack.peek();
  }
}
