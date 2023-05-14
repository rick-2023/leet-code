package tag.linkedList.medium;

import common.ListNode;

/**
 * case1
 * Input: head = [1,2,3,3,4,4,5]
 * Output: [1,2,5]
 * <p>
 * case2
 * Input: head = [1,1,1,2,3]
 * Output: [2,3]
 *
 * @author zrfan
 * @date 2023/05/14.
 */
public class RemoveDuplicatesFromSortedListII_82 {

  public ListNode deleteDuplicates(ListNode head) {

    if (head == null) return null;

    ListNode dummy = new ListNode();
    dummy.next = head;

    ListNode cur = dummy;

    while (cur.next != null && cur.next.next != null) {

      if (cur.next.val == cur.next.next.val) {

        // 暂存重复的值
        int val = cur.next.val;
        while (cur.next != null && cur.next.val == val) {
          cur.next = cur.next.next;
        }
      } else {
        cur = cur.next;
      }

    }

    return dummy.next;
  }
}
