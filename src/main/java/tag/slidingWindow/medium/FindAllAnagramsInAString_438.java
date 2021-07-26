package tag.slidingWindow.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * sliding window 问题 第一次遇见。还不熟悉
 *
 * https://github.com/labuladong/fucking-algorithm/blob/master/%E7%AE%97%E6%B3%95%E6%80%9D%E7%BB%B4%E7%B3%BB%E5%88%97/%E6%BB%91%E5%8A%A8%E7%AA%97%E5%8F%A3%E6%8A%80%E5%B7%A7.md
 *
 * @author zrfan
 * @date 2021/07/15.
 */
public class FindAllAnagramsInAString_438 {


  public List<Integer> findAnagrams(String s, String p) {

    List<Integer> res = new ArrayList<>();
    Map<Character, Integer> map = new HashMap<>();

    // 目标字符串 每个字符出现的次数
    for (int i = 0; i < p.length(); i++) {
      map.put(p.charAt(i), map.getOrDefault(p.charAt(i), 0) + 1);
    }


    // 这里 counter 是 map 的长度而非 p.length()
    int start = 0, end = 0, counter = map.size();

    while (end < s.length()) {

      Character c = s.charAt(end);

      if (map.containsKey(c)) {

        map.put(c, map.get(c) - 1);

        if (map.get(c) == 0)
          counter--;
      }

      end++;

      while (counter == 0) {

        // 上面减掉的 value重新加回去
        Character tempc = s.charAt(start);

        if (map.containsKey(tempc)) {
          map.put(tempc, map.get(tempc) + 1);

          if (map.get(tempc) > 0) {
            counter++;
          }
        }


        // 当左右指针为目标字符长度
        if (end - start == p.length()) {
          res.add(start);
        }

        start++;


      }


    }

    return res;

  }


  public static void main(String[] args) {
    FindAllAnagramsInAString_438 findAllAnagramsInAString_438 = new FindAllAnagramsInAString_438();
    List<Integer> anagrams = findAllAnagramsInAString_438.findAnagrams("baa", "aa");

    System.out.println(anagrams);
  }

}
