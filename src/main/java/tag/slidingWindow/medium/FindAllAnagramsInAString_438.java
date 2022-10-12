package tag.slidingWindow.medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * sliding window 问题 第一次遇见。还不熟悉
 * <p>
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


  /**
   * Input: s = "abab", p = "ab"
   * Output: [0,1,2]
   * Explanation:
   * The substring with start index = 0 is "ab", which is an anagram of "ab".
   * The substring with start index = 1 is "ba", which is an anagram of "ab".
   * The substring with start index = 2 is "ab", which is an anagram of "ab".
   *
   * @param s
   * @param p
   * @return
   */
  public static List<Integer> findAnagrams2(String s, String p) {

    List<Integer> list = new ArrayList<>();

    Map<Character, Integer> need = new HashMap<>();
    Map<Character, Integer> window = new HashMap<>();


    char[] pp = p.toCharArray();
    for (char c : pp) {
      need.put(c, need.getOrDefault(c, 0) + 1);
    }

    int left = 0, right = 0;
    int valid = 0;
    char[] ss = s.toCharArray();

    while (right < s.length()) {

      char c = ss[right];
      right++;

      if (need.containsKey(c)) {
        // 右边加元素
        window.put(c, window.getOrDefault(c, 0) + 1);
        if (window.get(c).equals(need.get(c))) {
          valid++;
        }
      }

      // 缩短左边的区间
      while (right - left >= p.length()) {

        if (valid == need.size()) {
          list.add(left);
        }

        char d = ss[left];

        if (need.containsKey(d)) {

          if (window.get(d).equals(need.get(d))) {
            valid--;
          }
          // 走到这 说明window一定包含了d
          window.put(d, window.get(d) - 1);
        }


        left++;

      }
    }

    return list;
  }

  @Test
  public void test2() {
    List<Integer> list = findAnagrams2("cbaebabacd", "abc");
    System.out.println(list);
  }

  public static void main(String[] args) {
    FindAllAnagramsInAString_438 findAllAnagramsInAString_438 = new FindAllAnagramsInAString_438();
    List<Integer> anagrams = findAllAnagramsInAString_438.findAnagrams("baa", "aa");

    System.out.println(anagrams);
  }

}
