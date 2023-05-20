package tag.linkedList.medium;

import common.ListNode;

/**
 *
 * Input: head = [1,2,3,4,5]
 * Output: [1,5,2,4,3]
 *
 * 思路
 * 1.一分为二，快慢指针
 * 2.后半部分反转链表 tail迭代
 * 3.链表合并
 *
 * 5.22回顾
 * @author zrfan
 * @date 2023/05/20.
 */
public class ReorderList_143 {

  public void reorderList(ListNode head) {

    if (head == null || head.next == null) {
      return;
    }

    ListNode slow = head, fast = head;
    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    ListNode l2 = slow.next;
    // 断开
    slow.next = null;

    l2 = reverse(l2);

    while (l2 != null) {

      ListNode temp = l2.next;
      l2.next = head.next;
      head.next = l2;

      head = l2.next;
      l2 = temp;


    }


  }

  private ListNode reverse(ListNode node) {
    if (node == null) return null;

    ListNode tail = node;
    node = node.next;
    tail.next = null;

    while (node != null) {
      ListNode temp = node.next;
      node.next = tail;
      tail = node;
      node = temp;
    }
    return tail;
  }
}
