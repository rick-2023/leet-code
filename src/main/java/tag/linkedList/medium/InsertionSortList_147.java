package tag.linkedList.medium;

import common.ListNode;

/**
 * Input: head = [4,2,1,3]
 * Output: [1,2,3,4]
 * <p>
 * 插入排序 时间复杂度O(n^2); 空间复杂度 O(1)
 *
 * dummy
 * 0
 * 0->4
 * 0->2->4
 * 0->1->2->4
 * 0->1->2->3->4
 *
 * @author zrfan
 * @date 2023/05/29.
 */
public class InsertionSortList_147 {

  public ListNode insertionSortList(ListNode head) {

    if (head == null || head.next == null) {
      return head;
    }

    ListNode dummy = new ListNode(0);

    ListNode cur = head;
    while (cur != null) {

      ListNode prev = dummy, next = cur.next;


      if (prev.next == null) {
        prev.next = cur;
        cur = cur.next;

        continue;
      }

      // 找到插入的位置
      while (prev.next != null && prev.next.val <= cur.val) {

        prev = prev.next;

      }

      cur.next = prev.next;
      prev.next = cur;
      cur = next;



    }


    return dummy.next;

  }
}
