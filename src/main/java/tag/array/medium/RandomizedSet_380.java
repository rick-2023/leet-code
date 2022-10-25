package tag.array.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * 实现O(1) 时间复杂度内 增，删，以及等概率获取元素
 * @author zrfan
 * @date 2022/10/25.
 */
public class RandomizedSet_380 {

  private List<Integer> list;
  private Set<Integer> set;
  private Random rand;

  public RandomizedSet_380() {

    list = new ArrayList<>();
    set = new HashSet<>();
    rand = new Random();
  }

  public boolean insert(int val) {

    if (set.contains(val)){
      return false;
    }

    set.add(val);
    list.add(val);
    return true;

  }

  public boolean remove(int val) {

    if (!set.contains(val)) {
      return false;
    }

    set.remove(val);
    list.remove(Integer.valueOf(val));
    return true;

  }

  public int getRandom() {

    return list.get(rand.nextInt(set.size()));

  }
}
