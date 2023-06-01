package tag.linkedList.medium;

import common.ListNode;

/**
 * Input: head = [1,2,3], k = 5
 * Output: [[1],[2],[3],[],[]]
 * Explanation:
 * The first element output[0] has output[0].val = 1, output[0].next = null.
 * The last element output[4] is null, but its string representation as a ListNode is [].
 * <p>
 * Input: head = [1,2,3,4,5,6,7,8,9,10], k = 3
 * Output: [[1,2,3,4],[5,6,7],[8,9,10]]
 * Explanation:
 * The input has been split into consecutive parts with size difference at most 1, and earlier parts are a larger size than the later parts.
 * <p>
 * 大致思路
 * 先计算出链表的长度
 * 分别除以k + 对k取模 计算出数组每个链表需要的长度
 *
 * @author zrfan
 * @date 2023/06/01.
 */
public class SplitLinkedListInParts_725 {

  public ListNode[] splitListToParts(ListNode head, int k) {

    int len = 0;
    ListNode temp = head;
    while (temp != null) {
      temp = temp.next;
      len++;
    }


    ListNode[] res = new ListNode[k];
    // 需要分摊给前x个节点 各1个
    int mod = len % k;
    int size = len / k;


    // 重新指向头节点
    temp = head;
    for (int i = 0; i < k && temp != null; i++) {

      res[i] = temp;
      int curSize = size + (mod-- > 0 ? 1 : 0);
      for (int j = 0; j < curSize - 1; j++) {
        temp = temp.next;
      }

      ListNode next = temp.next;
      temp.next = null;
      temp = next;

    }

    return res;
  }
}
