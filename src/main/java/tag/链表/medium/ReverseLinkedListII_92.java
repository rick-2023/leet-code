package tag.链表.medium;

import common.ListNode;

/**
 * Input: head = [1,2,3,4,5], left = 2, right = 4
 * Output: [1,4,3,2,5]
 *
 * @author zrfan
 * @date 2022/02/13.
 */
public class ReverseLinkedListII_92 {

  /**
   * 反转链表的一部分
   * 思路
   * 1.将待反转的链表分成3段
   *
   * @param head  头节点
   * @param left  起始
   * @param right 结束
   * @return 反转后的链表
   */
  public ListNode reverseBetween(ListNode head, int left, int right) {


    // 1 -> 2 -> 3 -> 4 -> 5  ===> 1 -> 4 -> 3 -> 2 -> 5
    ListNode dummy = new ListNode(-1);
    dummy.next = head;

    // 找到 第一段的最后一个节点, 即1
    ListNode first = dummy;
    for (int i = 1; i < left; i++) {
      first = first.next;
    }

    // 反转前第二段的第一个节点，即2，反转后变成第二段的最后一个节点
    ListNode second = first.next;

    if (second == null) {
      return dummy.next;
    }

    ListNode l = second; // 操作完后，变成第二段的第1个节点，即4
    ListNode r = l.next; // 操作完后，变成第三段的第1个节点，即5

    for (int i = left; i < right; i++) {

      ListNode temp = r.next;
      r.next = l;
      l=r;
      r=temp;

    }

    //上面循环结束，中间这段就反转完了 变成 1 -> 2<-3<-4 -> 5, 需要将1指向4，2指向5

    first.next = l;
    second.next = r;

    return dummy.next;
  }
}
