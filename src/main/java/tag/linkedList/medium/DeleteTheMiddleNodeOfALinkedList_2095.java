package tag.linkedList.medium;

import common.ListNode;

/**
 * Input: head = [1,3,4,7,1,2,6]
 * Output: [1,3,4,1,2,6]
 * Explanation:
 * The above figure represents the given linked list. The indices of the nodes are written below.
 * Since n = 7, node 3 with value 7 is the middle node, which is marked in red.
 * We return the new list after removing this node.
 * <p>
 * Input: head = [1,2,3,4]
 * Output: [1,2,4]
 * Explanation:
 * The above figure represents the given linked list.
 * For n = 4, node 2 with value 3 is the middle node, which is marked in red.
 * <p>
 * <p>
 * Input: head = [2,1]
 * Output: [2]
 * Explanation:
 * The above figure represents the given linked list.
 * For n = 2, node 1 with value 1 is the middle node, which is marked in red.
 * Node 0 with value 2 is the only node remaining after removing node 1.
 *
 * @author zrfan
 * @date 2023/05/29.
 */
public class DeleteTheMiddleNodeOfALinkedList_2095 {

  public ListNode deleteMiddle(ListNode head) {

    if (head == null || head.next == null) {
      return head;
    }

    int len = 1;
    ListNode cur = head;
    while (cur.next != null) {
      len++;
      cur = cur.next;
    }

    cur = head;

    int mid = len % 2 == 0 ? (len >> 1) : (len - 1) >> 1;

    for (int i = 0; i < mid - 1; i++) {
      cur = cur.next;
    }

    cur.next = cur.next.next;
    return head;

  }

  public ListNode deleteMiddle2(ListNode head) {

    if (head == null || head.next == null) {
      return null;
    }

    ListNode fast = head.next, slow = head;
    while (fast.next != null && fast.next.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }

    // 找到中点
    slow.next = slow.next.next;
    return head;

  }

  public static void main(String[] args) {

    ListNode node1 = new ListNode(1);
    ListNode node2 = new ListNode(3);
    ListNode node3 = new ListNode(4);
    ListNode node4 = new ListNode(7);
    ListNode node5 = new ListNode(1);
    ListNode node6 = new ListNode(2);
    ListNode node7 = new ListNode(6);

    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
    node4.next = node5;
    node5.next = node6;
    node6.next = node7;
    node7.next = null;

    DeleteTheMiddleNodeOfALinkedList_2095 deleteTheMiddleNodeOfALinkedList2095 = new DeleteTheMiddleNodeOfALinkedList_2095();
    deleteTheMiddleNodeOfALinkedList2095.deleteMiddle(node1);

    ListNode temp = node1;
    while (temp != null) {
      System.out.println(temp.val);
      temp = temp.next;
    }
  }
}
