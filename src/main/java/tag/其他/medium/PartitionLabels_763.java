package tag.其他.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zrfan
 * @date 2021/7/17 16:55
 */
public class PartitionLabels_763 {

  /**
   * Input: s = "ababcbacadefegdehijhklij"
   * Output: [9,7,8]
   * Explanation:
   * The partition is "ababcbaca", "defegde", "hijhklij".
   * This is a partition so that each letter appears in at most one part.
   * A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts.
   *
   * 思路
   *  1.用map维护字符串s中各字符出现的最后一个位置，例如 a最后一个index=8
   *  2.使用头尾指针start, end来移动字符串，若当前位置i为该字符串出现的最后一个位置 则start-->end这段符合题意，直接截断，放到res结果集中
   *  3.然后 将end++, start移到end(其实已经是end+1)处
   *
   * 测试下提交
   *
   *
   * @param s s
   * @return res
   */
  public List<Integer> partitionLabels(String s) {

    List<Integer> res = new ArrayList<>();
    char[] chars = s.toCharArray();

    Map<Character,Integer> map = new HashMap<>();
    for(int i=0;i<chars.length;i++){
      map.put(chars[i], i);
    }

    int start=0,end=0;
    for(int i=0;i<chars.length;i++){

      end=Math.max(end,map.get(chars[i]));

      if(end == i) {

        res.add(end-start+1);
        end++;
        start = end;


      }


    }

    return res;
  }

}
