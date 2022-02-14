package tag.linkedList.medium;

import common.ListNode;

/**
 * Input: list1 = [0,1,2,3,4,5], a = 3, b = 4, list2 = [1000000,1000001,1000002]
 * Output: [0,1,2,1000000,1000001,1000002,5]
 *
 * @author zrfan
 * @date 2022/02/14.
 */
public class MergeInBetweenLinkedLists_1669 {

  public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {

    // 2
    ListNode l1_first = list1;
    for (int i = 0; i < a-1; i++) {
      l1_first = l1_first.next;
    }

    // 5
    ListNode l1_second = l1_first;
    for (int i = a; i <= b + 1; i++) {
      l1_second = l1_second.next;
    }

    // 1000002
    ListNode l2_tail = list2;
    while (l2_tail.next != null) {
      l2_tail = l2_tail.next;
    }

    // 2->1000000
    l1_first.next = list2;
    // 1000002->5
    l2_tail.next = l1_second;

    return list1;

  }
}
