package tag.backtracking.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Input
 * ["CombinationIterator", "next", "hasNext", "next", "hasNext", "next", "hasNext"]
 * [["abc", 2], [], [], [], [], [], []]
 * Output
 * [null, "ab", true, "ac", true, "bc", false]
 * <p>
 * Explanation
 * CombinationIterator itr = new CombinationIterator("abc", 2);
 * itr.next();    // return "ab"
 * itr.hasNext(); // return True
 * itr.next();    // return "ac"
 * itr.hasNext(); // return True
 * itr.next();    // return "bc"
 * itr.hasNext(); // return False
 *
 *
 * 好像对回溯有明白了一点。。。
 *
 * @author zrfan
 * @date 2021/07/25.
 */
public class CombinationIterator_1286 {


  private Queue<String> list;

  public CombinationIterator_1286(String characters, int combinationLength) {

    list = new LinkedList<>();
    help(characters, combinationLength, new StringBuilder(), 0);

  }

  private void help(String characters, int combinationLength, StringBuilder stringBuilder, int index) {

    if (stringBuilder.length() == combinationLength) {
      list.add(stringBuilder.toString());
      return;
    }

    for (int i = index; i < characters.length(); i++) {

      stringBuilder.append(characters.charAt(i));
      help(characters, combinationLength, stringBuilder, i + 1);
      stringBuilder.deleteCharAt(stringBuilder.length() - 1);

    }


  }


  public String next() {

    return list.poll();

  }

  public boolean hasNext() {

    return list.size() != 0;
  }
}
