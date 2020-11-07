package tag.array.medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author zrfan
 * @date 2020/02/03.
 */
public class LeetCode_347 {

  public List<Integer> topKFrequent(int[] nums, int k) {

    List<Integer> result = new ArrayList<>();

    // key：数 ---->  value：频率
    Map<Integer, Integer> map = new HashMap<>(16);
    for (int i = 0; i < nums.length; i++) {

      map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

    }

    PriorityQueue<Map.Entry<Integer,Integer>> queue = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
      @Override
      public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
        return o2.getValue() - o1.getValue();
      }
    });

    // 出现频率
    Set<Map.Entry<Integer,Integer>> set = map.entrySet();
    for(Map.Entry<Integer,Integer> entry : set){
      queue.add(entry);
    }


    for (int i=0;i<k;i++){
      result.add(queue.poll().getKey());
    }

    return result;

  }
}
