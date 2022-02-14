package tag.linkedList.easy;


import java.util.Arrays;

/**
 * @author zrfan
 * @date 2022/02/14.
 */
public class MyHashMap_706 {

  private final int SIZE = 100001;

  int[] buckets;

  public MyHashMap_706() {

    buckets = new int[SIZE];
    // 全部填充为-1
    Arrays.fill(buckets, -1);

  }

  public void put(int key, int value) {


    buckets[key] = value;

  }

  public int get(int key) {

    return buckets[key] != -1 ? buckets[key] : -1;
  }

  public void remove(int key) {

    buckets[key] = -1;

  }


}
