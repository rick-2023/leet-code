package tag.slidingWindow.medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author zrfan
 * @date 2022/10/13.
 */
public class RepeatedDNASequences_187 {

  public static List<String> findRepeatedDnaSequences(String s) {

    int[] nums = new int[s.length()];
    for (int i = 0; i < nums.length; i++) {

      char c = s.charAt(i);

      switch (c) {

        case 'A':
          nums[i] = 0;
          break;
        case 'G':
          nums[i] = 1;
          break;
        case 'C':
          nums[i] = 2;
          break;
        case 'T':
          nums[i] = 3;
          break;
      }
    }


    HashSet<Integer> seen = new HashSet<>();
    HashSet<String> res = new HashSet<>();


    int right = 0, left = 0;
    int R = 4;
    int L = 10;
    // 巧妙利用4进制
    int RL = (int) Math.pow(R, L - 1);
    int windowHash = 0;

    while (right < s.length()) {

      // 扩大右边窗口
      windowHash = R * windowHash + nums[right];
      right++;

      if (right - left == L) {

        if (seen.contains(windowHash)) {
          res.add(s.substring(left, right));
        } else {
          seen.add(windowHash);
        }

        // 缩小左边窗口
        windowHash = windowHash - nums[left] * RL;
        left++;

      }

    }

    return new ArrayList<>(res);

  }


  @Test
  public void test() {
    List<String> list = findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
    System.out.println(list);
  }
}
