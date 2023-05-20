package tag.linkedList.medium;

import common.ListNode;

/**
 * Input: head = [0,3,1,0,4,5,2,0]
 * Output: [4,11]
 * Explanation:
 * The above figure represents the given linked list. The modified list contains
 * - The sum of the nodes marked in green: 3 + 1 = 4.
 * - The sum of the nodes marked in red: 4 + 5 + 2 = 11.
 *
 * @author zrfan
 * @date 2023/05/18.
 */
public class MergeNodesInBetweenZeros_2181 {

  /**
   * 思路
   * 构造一个空的链表，当元素不为0是先累加起来，当遇到为0时，把cur指向新的node（sum）然后sum置为0，然后cur指向新的node
   *
   * @param head 头结点
   * @return 新链表
   */
  public ListNode mergeNodes(ListNode head) {

    if (head == null) {
      return null;
    }

    int sum = 0;
    head = head.next;
    ListNode dummy = new ListNode();
    ListNode cur = dummy;


    while (head != null) {

      if (head.val == 0) {
        cur.next = new ListNode(sum);
        // cur移到后置节点
        cur = cur.next;
        sum = 0;
      } else {
        sum += head.val;
      }

      head = head.next;
    }

    return dummy.next;

  }
}
