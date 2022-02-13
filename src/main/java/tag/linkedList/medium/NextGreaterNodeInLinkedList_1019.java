package tag.linkedList.medium;

/**
 * @author zrfan
 * @date 2019/12/22.
 */
public class NextGreaterNodeInLinkedList_1019 {

  /**
   * 问题描述
   *  单链表返回比节点右边第一个大的值，若没有则为0 数组返回
   * 思路
   *  stack 后进先出，逆向思维
   *  最后一个节点肯定是0
   *    利用2个栈
   *      stack1 将节点全部入栈，栈顶即链表的尾节点
   *      数组长度为stack1.size()
   *      循环stack1
   *        依次出栈 curr
   *        若stack2 不为空则
   *          while比较 stack2的栈顶元素 与 curr大小。 如果curr比stack2栈顶元素大 则stack2.pop()
   *
   *          if (stack2 为空)
   *            数组[i--] = 0
   *          else
   *            数组[i--] = stack2.peek()
   *
   *          stack2.push(curr);
   *
   *
   *
   */
}
