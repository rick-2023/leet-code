package tag.linkedList.medium;

import common.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Input: head = [0,1,2,3], nums = [0,1,3]
 * Output: 2
 * Explanation: 0 and 1 are connected, so [0, 1] and [3] are the two connected components.
 *
 * 思路： 1.先用set存储数组中的所有元素 2.遍历链表 若一段连续的节点（直到不在为止）都在set里 则count++;
 *
 * 还需要再回顾细品一下
 *
 * @author zrfan
 * @date 2023/06/04.
 */
public class LinkedListComponents_817 {

  public int numComponents(ListNode head, int[] nums) {

    Set<Integer> set = new HashSet<>();
    for (int num : nums) {
      set.add(num);
    }

    ListNode cur = head;
    int count = 0;

    while (cur != null) {

      if (set.contains(cur.val)){
       while (cur.next!= null && set.contains(cur.next.val)) {
         cur = cur.next;
       }
       count++;
      }
      cur = cur.next;
    }

    return count;

  }
}
