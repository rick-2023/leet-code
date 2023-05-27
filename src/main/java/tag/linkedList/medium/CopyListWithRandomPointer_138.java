package tag.linkedList.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 深拷贝链表
 *
 * 思路 用一个Map维护拷贝前后新旧node之间的映射，第一次遍历先维护val,第二次从map取出维护next和random
 *
 * @author zrfan
 * @date 2023/05/27.
 */
public class CopyListWithRandomPointer_138 {

  class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
      this.val = val;
      this.next = null;
      this.random = null;
    }
  }

  public Node copyRandomList(Node head) {
    if(head==null) return null;

    Map<Node,Node> map = new HashMap<>();

    Node cur = head;
    while(cur!=null){
      map.put(cur, new Node(cur.val));
      cur = cur.next;
    }

    // 循环完cur重置
    cur = head;
    while(cur != null) {
      // 细品
      map.get(cur).next = map.get(cur.next);
      map.get(cur).random = map.get(cur.random);
      cur = cur.next;
    }

    return map.get(head);
  }

}
