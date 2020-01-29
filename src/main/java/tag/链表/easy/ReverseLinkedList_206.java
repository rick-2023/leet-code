package tag.链表.easy;

/**
 * @author zrfan
 * @date 2019/12/22.
 */
public class ReverseLinkedList_206 {

  /**
   * 解题思路
   *  单链表反转遍历
   *
   * ListNode curr = head;
   *         ListNode prev = null;
   *
   *         while(curr != null){
   *
   *             ListNode next = curr.next;
   *             // 当前节点的下一个节点指向prev
   *             curr.next = prev;
   *             prev = curr;
   *             curr = next;
   *         }
   *
   *         return prev;
   *
   */
}
