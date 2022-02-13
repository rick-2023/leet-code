package tag.linkedList.easy;

import common.ListNode;

/**
 * Input: head = [5,4,2,1]
 * Output: 6
 * 给的偶数长度，对称两个节点之和最大是多少
 *
 * @author zrfan
 * @date 2022/02/13.
 */
public class MaximumTwinSumOfLinkedList_2130 {


  /**
   * 思路 快慢指针找到中点，然后再分别往前，往后推进，计算
   *
   * @param head
   * @return
   */
  public int pairSum(ListNode head) {

    ListNode slow = head, fast = head;

    // 先找中点
    while (fast != null && fast.next != null) {

      slow = slow.next;
      fast = fast.next.next;

    }

    // 将后半部分链表反转
    ListNode cur = slow, prev = null;
    while (cur != null) {
      ListNode next = cur.next;
      cur.next = prev;
      prev = cur;
      cur = next;
    }

    int sum = 0;

    // 分别从head 和 prev 两端开始求和max
    while (head != null && prev != null) {

      sum = Math.max(sum, head.val + prev.val);
      head = head.next;
      prev = prev.next;
    }

    return sum;


  }
}
