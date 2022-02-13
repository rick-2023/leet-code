package tag.linkedList.easy;

import common.ListNode;

/**
 * @author zrfan
 * @date 2019/12/21.
 */
public class PalindromeLinkedList_234 {

  /*
   * 问题描述
   *  判断单链表是否回环
   *
   * 解题思路
   *  1.快慢节点 分为前后2段
   *  2.fast节点反转 参考206
   *  3.判断2部分节点是否一致
   */

  public boolean isPalindrome(ListNode head) {

    ListNode slow = head, fast = head;
    // 注意快慢指针的写法
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    // 注意如果链表长度为奇数,slow往前一步，不要把中间这个节点也反转了
    if (fast != null) {
      slow = slow.next;
    }

    ListNode left = head;
    // 反转slow后面的这些节点
    ListNode right = reverse(slow);

    while (right != null) {
      if (left.val != right.val) {
        return false;
      }
      left = left.next;
      right = right.next;
    }

    return true;

  }


  public ListNode reverse(ListNode head) {

    ListNode pre = null, cur = head, next = null;
    while (cur != null) {
      next = cur.next;
      cur.next = pre;
      pre = cur;
      cur = next;
    }

    return pre;

  }
}
