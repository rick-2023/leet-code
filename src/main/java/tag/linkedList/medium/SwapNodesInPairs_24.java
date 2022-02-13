package tag.linkedList.medium;

import common.ListNode;
import tag.linkedList.hard.ReverseNodesInKGroup_25;

/**
 * 调用第25题的解题思路，k=2代入即可
 *
 * @author zrfan
 * @date 2022/02/13.
 */
public class SwapNodesInPairs_24 {
  public ListNode swapPairs(ListNode head) {
    return new ReverseNodesInKGroup_25().reverseKGroup(head, 2);
  }
}
