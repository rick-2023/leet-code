package tag.array.hard;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author zrfan
 * @date 2022/10/28.
 */
public class RandomPickWithBlacklist_710 {

  Map<Integer, Integer> map;
  int range;
  Random r;
  int m;

  public RandomPickWithBlacklist_710() {

  }

  public RandomPickWithBlacklist_710(int n, int[] blacklist) {

    // {i}
    map = new HashMap<>();

    //n=5, arr=[0,1,2,3,4] blacklist=[1,3]--->arr[0,2,4,1,3]  random=[0,2,4]
    // range = 5-2=3, 如果0-2中有存在blacklist中的 重新摇
    range = n - blacklist.length;

    for (int i : blacklist) {
      map.put(i, -1);
    }


    for (int b : blacklist) {


      if (b < range) {

        while (map.containsKey(n - 1)) {
          n--;
        }

        map.put(b, n - 1);
        n--;

      }

    }
    r = new Random();


  }

  public int pick() {

    int i = r.nextInt(range);

    if (map.containsKey(i)){
      return map.get(i);
    }

    return i;

  }

  public static void main(String[] args) {

    RandomPickWithBlacklist_710 randomPickWithBlacklist_710 = new RandomPickWithBlacklist_710(5, new int[]{1,3,4});
    for (int i = 0; i < 100; i++) {

      int pick = randomPickWithBlacklist_710.pick();
      System.out.println(pick);
    }
  }
}
