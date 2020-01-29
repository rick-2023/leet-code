package tag.链表.easy;

/**
 * @author zrfan
 * @date 2019/12/22.
 */
public class RemoveLinkedListElements_203 {

  /**
   * 问题描述
   *  将链表中与指定值相同的节点都移除
   * 思路
   *  构造一个虚拟节点dummy指向head ---> dummy.next = head
   *  另外用一个指针node 指向 dummy
   *  循环
   *    判断是否相等 相等则 n.next = n.next.next
   *    否则 n = n.next
   */
}
