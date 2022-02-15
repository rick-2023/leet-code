package tag.linkedList.medium;

import common.ListNode;

/**
 * 交换第k个节点
 * <p>
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [1,4,3,2,5]
 *
 * @author zrfan
 * @date 2022/02/15.
 */
public class SwappingNodesInALinkedList_1721 {

  /**
   * 比较简单，暴力破解
   *  1.找到开始第k个，k1
   *  2.计算出链表长度
   *  3.找到末尾数上来第k个, k2
   *
   *  用个temp交换k1, k2 的val
   */
  public ListNode swapNodes(ListNode head, int k) {

    ListNode k1 = head;
    for (int i = 1; i < k; i++) {
      k1 = k1.next;
    }

    int n = 0;
    ListNode cur = head;
    while (cur != null) {
      cur = cur.next;
      n++;
    }

    ListNode k2 = head;
    for (int i = 1; i < n - k + 1; i++) {

      k2 = k2.next;

    }

    int temp = k1.val;
    k1.val = k2.val;
    k2.val = temp;

    return head;
  }


}
