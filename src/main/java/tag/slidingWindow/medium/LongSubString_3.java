package tag.slidingWindow.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * abba -->2
 * 最长子串 首先考虑滑动窗口，两个快慢指针，一个 map 空间换时间
 * 没出现过的元素直接 put<char, index> ,已经出现过的 更新到上次出现位置的后一位，同时将慢指针 slow移到该位置
 * @author zrfan
 * @date 2021/07/05.
 */
public class LongSubString_3 {

  public int lengthOfLongestSubstring(String s) {

    // 记录每个字符最近一次出现的位置
    Map<Character, Integer> lastOccurred = new HashMap<>();

    if (s == null || s.length() == 0) {
      return 0;
    }

    char[] letters = s.toCharArray();

    int fast = 0, slow = 0, max = 0;
    for (; fast < s.length(); fast++) {

      char c = letters[fast];
      if (lastOccurred.containsKey(c)) {

        // abba 刚开始到最后一个 a的时候，slow=2,走完逻辑后，slow=1之前 a出现在 0，故+1=1，注意 slow 不能往前退了，所以 slow= Math.max(slow,xxx);
        slow = Math.max(slow, lastOccurred.get(c) + 1);

      }

      lastOccurred.put(c, fast);
      max = Math.max(max, fast - slow + 1);

    }


    return max;
  }

  public static void main(String[] args) {

    LongSubString_3 longSubString_3 = new LongSubString_3();
    String s = "abba";
    int i = longSubString_3.lengthOfLongestSubstring(s);
    System.out.println(i);

  }
}
