package tag.linkedList.medium;

import common.ListNode;

/**
 * Input: l1 = [7,2,4,3], l2 = [5,6,4]
 * Output: [7,8,0,7]
 *
 * @author zrfan
 * @date 2023/05/31.
 */
public class AddTwoNumbersII_445 {

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

    l1 = reverse(l1);
    l2 = reverse(l2);

    int carry = 0;
    ListNode dummy = new ListNode(0);
    ListNode cur = dummy;

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
      carry = sum / 10;

      ListNode node = new ListNode(sum % 10);
      cur.next = node;
      cur = cur.next;


    }

    return reverse(dummy.next);

  }

  private ListNode reverse(ListNode head) {
    ListNode prev = null, next = null;
    while (head != null) {
      next = head.next;
      head.next = prev;

      prev = head;
      head = next;
    }

    return prev;
  }
}
