package tag.linkedList.medium;

import common.DoublyNode;

/**
 *
 * 将链表由多层转为扁平化
 *
 * 1.有点深度优先的感觉，先拿child节点那层的tail节点
 *
 * 2.注意双向链表要同时维护好prev 和 next
 *
 * @author zrfan
 * @date 2022/02/19.
 */
public class FlattenAMultilevelDoublyLinkedList_430 {


  public DoublyNode flatten(DoublyNode head) {

    DoublyNode cur = head;

    while (cur != null) {

      if (cur.child != null) {

        // 找到child层的tail节点
        DoublyNode tail = findTail(cur.child);

        // 跟父级的next建立前驱关系
        if (cur.next != null) {
          cur.next.prev = tail;
        }
        // tail的后驱执行父级的下一个节点
        tail.next = cur.next;
        // 随之父级后驱就指向了子节点
        cur.next = cur.child;

        cur.child.prev = cur;
        // 题目中要求子节点要置为null
        cur.child = null;

      }

      cur = cur.next;

    }

    return head;

  }

  private DoublyNode findTail(DoublyNode node) {

    while (node.next != null) {

      node = node.next;
    }

    return node;
  }
}
