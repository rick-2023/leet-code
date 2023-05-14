package tag.linkedList.medium;

import common.ListNode;

/**
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [4,5,1,2,3]
 *
 * @author zrfan
 * @date 2023/05/14.
 */
public class RotateList_61 {

  public ListNode rotateRight(ListNode head, int k) {

    if (head == null) return null;

    int len = 1;
    ListNode temp = head;

    while (temp.next != null) {
      len++;
      temp = temp.next;
    }

    // 成环
    temp.next = head;

    int index = len - k % len;

    for (int i = 0; i < index; i++) {
      temp = temp.next;
    }

    // 新head
    head = temp.next;
    // 环断掉
    temp.next = null;


    return head;
  }
}
