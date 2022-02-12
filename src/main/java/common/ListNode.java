package common;

import tag.链表.medium.SortList_148;

/**
 * @author zrfan
 * @date 2019/12/22.
 */
public class ListNode {

  public int val;
  public ListNode next;

  ListNode(int x) {
    val = x;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}
