package tag.数组.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zrfan
 * @date 2020/02/07.
 */
public class LeetCode_49 {

  /**
   * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
   * Output:
   * [
   * ["ate","eat","tea"],
   * ["nat","tan"],
   * ["bat"]
   * ]
   *
   * 思路 借助hashMap,对每个str进行排序作为key
   */
  public List<List<String>> groupAnagrams(String[] strs) {

    if (strs == null || strs.length == 0) {
      return new ArrayList<>();
    }

    Map<String, List<String>> map = new HashMap<>();
    for (String str : strs) {

      char[] charArr = str.toCharArray();
      Arrays.sort(charArr);

      String sortStr = String.valueOf(charArr);
      if (!map.containsKey(sortStr)) {
        map.put(sortStr, new ArrayList<>());
      }

      map.get(sortStr).add(str);

    }


    return new ArrayList<>(map.values());
  }

  // 测试
  public static void main(String[] args) {
    String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
    List<List<String>> lists = new ArrayList<>();

    LeetCode_49 leetCode_49 = new LeetCode_49();
    lists = leetCode_49.groupAnagrams(strs);

    System.out.println(lists);
  }
}
