package common;

/**
 * @author zrfan
 * @date 2019/12/22.
 */
public class ListNode {

  public int val;
  public ListNode next;

  public ListNode() {
  }

  public ListNode(int x) {
    this.val = x;
  }

  public ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}
