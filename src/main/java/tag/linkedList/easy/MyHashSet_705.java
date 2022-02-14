package tag.linkedList.easy;


import java.util.ArrayList;
import java.util.List;

/**
 * @author zrfan
 * @date 2022/02/14.
 */
public class MyHashSet_705 {

  final int TOTAL_BUCKETS = 769;
  // 数组中是list
  List<Integer>[] buckets;

  public MyHashSet_705() {

    buckets = new ArrayList[TOTAL_BUCKETS];
    for (int index = 0; index < TOTAL_BUCKETS; ++index)
      buckets[index] = new ArrayList<>();

  }

  public void add(int key) {

    if (contains(key)) {
      return;
    }

    int hashCodeIndex = hashCode(key);
    buckets[hashCodeIndex].add(key);


  }

  public void remove(int key) {

    if (!contains(key)) {
      return;
    }

    int hashCodeIndex = hashCode(key);
    List<Integer> list = buckets[hashCodeIndex];

    for(int index = 0; index < list.size(); ++index) {
      if(list.get(index) == key)
        list.remove(index);
    }


  }

  public boolean contains(int key) {

    int hashCodeIndex = hashCode(key);

    List<Integer> list = buckets[hashCodeIndex];
    if (list.size() == 0) {
      return false;
    }

    for (Integer i : list) {

      if (i == key) {
        return true;
      }

    }

    return false;

  }


  private int hashCode(int key) {
    return key % TOTAL_BUCKETS;
  }

}
