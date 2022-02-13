package tag.linkedList.easy;

import common.ListNode;

/**
 * Input: head = [4,5,1,9], node = 5
 * Output: [4,1,9]
 *
 * @author zrfan
 * @date 2022/02/12.
 */
public class DeleteNodeInALinkedList_237 {

  /**
   * 思路，因为不是从head节点开始，则需要先将node节点的next节点值赋值给node,并删除node.next
   */
  public void deleteNode(ListNode node) {

    // 4->5->1->9 把5后面的这个节点1删除，并删除的赋值给5
    node.val = node.next.val;
    // 删除节点1
    node.next = node.next.next;

  }
}
