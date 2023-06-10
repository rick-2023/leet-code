package tag.array.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 没有什么好讲的，把英文字符转为mose码，丢到set里即可
 * @author zrfan
 * @date 2023/06/10.
 */
public class UniqueMorseCodeWords_804 {

  private static final String[] full_table = {
          ".-","-...","-.-.","-..",".","..-.","--.",
          "....","..",".---","-.-",".-..","--","-.",
          "---",".--.","--.-",".-.","...","-","..-",
          "...-",".--","-..-","-.--","--.."
  };

  public int uniqueMorseRepresentations(String[] words) {

    int len = words.length;
    if(len <= 1){
      return len;
    }

    Set<String> set = new HashSet<>();

    for(int i=0; i<len; i++) {

      String eachWords = words[i];

      StringBuilder sb = new StringBuilder();
      for(Character c : eachWords.toCharArray()) {
        sb.append(full_table[c-'a']);
      }

      if(!set.contains(sb.toString())){
        set.add(sb.toString());
      }
    }

    return set.size();
  }


}
