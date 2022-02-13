package tag.linkedList.hard;

import common.ListNode;

/**
 *
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [2,1,4,3,5]
 *
 * k个一组反转链表
 * @author zrfan
 * @date 2022/02/13.
 */
public class ReverseNodesInKGroup_25 {

  /**
   * 思路根据全反转的题目可知，反转一个区间链表的代码如 reverse(a,b),作为help方法用于对k个小区间的链表进行反转
   *
   * 注意递归的bad case为，如k=2时，最后的5只剩1个小于2，直接终止递归
   *
   * 对于1->2来说，此时b指向了3，左闭右开，newHead指向了2，反转后的a为链表尾节点
   * 需要执行后面的递归出来头节点故 得到 a.next = reverseKGroup(b, k);
   *
   *
   * @param head
   * @param k
   * @return
   */
  public ListNode reverseKGroup(ListNode head, int k) {


    ListNode a, b;
    a = b = head;

    for (int i = 0; i < k; i++) {

      // 不足k个了
      if (b == null) {
        return head;
      }
      b = b.next;

    }


    ListNode newHead = reverse(a, b);

    a.next = reverseKGroup(b, k);

    return newHead;

  }


  // 反转a-b之间的节点 [左闭右开)
  public ListNode reverse(ListNode a, ListNode b) {

    ListNode pre, cur, next;
    pre = null;
    cur = a;

    while (cur != b) {
      next = cur.next;
      cur.next = pre;
      pre = cur;
      cur = next;
    }
    return pre;

  }
}
