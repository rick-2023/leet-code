package tag.linkedList.medium;

import com.sun.jmx.remote.internal.ArrayQueue;
import common.ListNode;

import java.util.ArrayDeque;

/**
 * Input: head = [5,2,13,3,8]
 * Output: [13,8]
 * Explanation: The nodes that should be removed are 5, 2 and 3.
 * - Node 13 is to the right of node 5.
 * - Node 13 is to the right of node 2.
 * - Node 8 is to the right of node 3.
 *
 * 借助双向队列+单调栈的思路
 *
 * @author zrfan
 * @date 2023/05/28.
 */
public class RemoveNodesFromLinkedList_2487 {

  public ListNode removeNodes(ListNode head) {

    ArrayDeque<ListNode> queue = new ArrayDeque<>();
    ListNode temp = head;

    while (temp != null){

      while (!queue.isEmpty() && queue.peekLast().val < temp.val){

        queue.removeLast();

      }

      queue.addLast(temp);
      temp = temp.next;
    }


    ListNode newHead = queue.removeFirst();
    temp = newHead;

    while (!queue.isEmpty()){
      temp.next = queue.removeFirst();
      temp = temp.next;
    }

    return newHead;
  }
}
