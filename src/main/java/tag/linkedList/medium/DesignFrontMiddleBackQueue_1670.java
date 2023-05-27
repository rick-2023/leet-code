package tag.linkedList.medium;

import java.util.LinkedList;

/**
 * 思路 熟练掌握linkedList的API
 * @author zrfan
 * @date 2023/05/27.
 */
public class DesignFrontMiddleBackQueue_1670 {

  LinkedList<Integer> queue;
  public DesignFrontMiddleBackQueue_1670() {
    queue = new LinkedList<>();
  }

  public void pushFront(int val) {
    queue.addFirst(val);
  }

  public void pushMiddle(int val) {

    int n = queue.size();
    int mid = n/2;

    queue.add(mid, val);
  }

  public void pushBack(int val) {
    queue.addLast(val);
  }

  public int popFront() {
    if (queue.isEmpty()){
      return -1;
    }
    return queue.removeFirst();
  }

  public int popMiddle() {

    if (queue.isEmpty()){
      return -1;
    }
    int n = queue.size();
    // 注意这里需要n-1移除前一个中点的
    int mid = (n-1)/2;
    return queue.remove(mid);
  }

  public int popBack() {
    if (queue.isEmpty()){
      return -1;
    }

    return queue.removeLast();
  }


}
