package tag.链表.easy;

import common.ListNode;

/**
 * @author zrfan
 * @date 2019/12/22.
 */
public class ReverseLinkedList_206 {

  /**
   * 解题思路
   * 单链表反转遍历
   * <p>
   * ListNode curr = head;
   * ListNode prev = null;
   * <p>
   * while(curr != null){
   * <p>
   * ListNode next = curr.next;
   * // 当前节点的下一个节点指向prev
   * curr.next = prev;
   * prev = curr;
   * curr = next;
   * }
   * <p>
   * return prev;
   */

  //
  public ListNode reverseList(ListNode head) {

    // 存储反转后的链表 头结点.那张纸出来画一画
    ListNode prev = null;
    ListNode cur = head;

    while (cur != null) {

      // 中间值，记录下个节点
      ListNode next = cur.next;
      // 往前指
      cur.next = prev;

      // 后移。初次循环 null<-1->2->3->4->5
      prev = cur;

      cur = next;


    }

    return prev;

  }


  // 递归 https://labuladong.github.io/algo/2/17/17/
  public ListNode reverse(ListNode head) {

    if (head == null || head.next == null) {
      return head;
    }

    ListNode last = reverse(head.next);

    head.next.next = head;
    head.next = null;
    return last;


  }
}
