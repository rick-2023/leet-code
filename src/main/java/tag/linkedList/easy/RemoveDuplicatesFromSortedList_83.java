package tag.linkedList.easy;

import common.ListNode;

/**
 * @author zrfan
 * @date 2019/12/21.
 */
public class RemoveDuplicatesFromSortedList_83 {

  /**
   * 解题思路
   * 定义一个当前节点指向head
   * while 循环
   * if 当前节点的值与next值一样，则当前节点指向next.next
   * else 指向next
   * return head
   */

  public ListNode deleteDuplicates(ListNode head) {

    ListNode cur = head;

    while (cur != null && cur.next != null) {

      if (cur.val == cur.next.val) {
        cur.next = cur.next.next;
      } else {
        cur = cur.next;
      }

    }

    return head;

  }

  /**
   * 快慢指针
   *
   * @param head
   * @return
   */
  public ListNode deleteDuplicates2(ListNode head) {

    // 1->1->2

    if (head == null) {
      return null;
    }

    ListNode slow = head, fast = head;

    while (fast != null) {

      if (slow.val != fast.val) {
        slow.next = fast;
        slow = slow.next;
      }

      fast = fast.next;
    }


    // 断开slow后面的元素后，最后返回head
    slow.next = null;

    return head;

  }

}
