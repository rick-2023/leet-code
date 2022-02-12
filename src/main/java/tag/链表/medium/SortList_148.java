package tag.链表.medium;


import common.ListNode;

/**
 * 归并排序 先 sort --> sort --> merge
 *
 * 平均时间复杂度 o(nlogn)
 * 空间复杂度 o(n)
 *
 * input [4,2,1,3]
 * output[1,2,3,4]
 *
 * @author zrfan
 * @date 2021/07/11.
 */
public class SortList_148 {


  // Definition for singly-linked list.


  public ListNode sortList(ListNode head) {


    // 快慢指针
    return sort(head, null);

  }

  private ListNode sort(ListNode start, ListNode end) {

    if (start == end) {
      return start;
    }

    ListNode slow = start, fast = start;

    // 注意这里是不等于 end，而不是 null...
    while (fast != end && fast.next != end) {

      fast = fast.next.next;
      slow = slow.next;


    }

    // 找到中点 不断拆分

    ListNode l2 = sort(slow.next, end);
    // 拆分时需要将两段链表 解除联系
    slow.next = null;
    ListNode l1 = sort(start, slow);

    return merge(l1, l2);

  }


  private ListNode merge(ListNode l1, ListNode l2) {

    if (l1 == null || l2 == null) {

      return l1 == null ? l2 : l1;
    }


    if (l1.val < l2.val) {
      l1.next = merge(l1.next, l2);
      return l1;
    } else {
      l2.next = merge(l2.next, l1);
      return l2;
    }

  }
}
