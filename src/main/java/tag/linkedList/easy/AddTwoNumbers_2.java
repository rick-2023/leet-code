package tag.linkedList.easy;

import common.ListNode;

/**
 * @author zrfan
 * @date 2023/04/09.
 */
public class AddTwoNumbers_2 {

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

    ListNode dummy = new ListNode(0);
    ListNode cur = dummy;

    int carry = 0;

    while (l1 != null || l2 != null || carry == 1) {

      int sum = 0;

      if (l1 != null) {
        sum += l1.val;
        l1 = l1.next;
      }

      if (l2 != null) {
        sum += l2.val;
        l2 = l2.next;
      }

      sum += carry;

      // 是否需要进位
      carry = sum / 10;

      cur.next = new ListNode(sum % 10);
      cur = cur.next;

    }


    return dummy.next;
  }
}
