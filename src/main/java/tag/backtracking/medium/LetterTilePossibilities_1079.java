package tag.backtracking.medium;


/**
 * Input: tiles = "AAB"
 * Output: 8
 * Explanation: The possible sequences are "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA".
 *
 * @author zrfan
 * @date 2021/07/24.
 */
public class LetterTilePossibilities_1079 {

  public static void main(String[] args) {
    LetterTilePossibilities_1079 letterTilePossibilities_1079 = new LetterTilePossibilities_1079();
    int aab = letterTilePossibilities_1079.numTilePossibilities("AAB");
    System.out.println(aab);
  }


  public int numTilePossibilities(String tiles) {


    int[] record = new int[26];
    for (Character c : tiles.toCharArray()) {
      record[c - 'A']++;
    }

    return help(record);
  }

  private int help(int[] record) {


    int sum = 0;

    for (int i = 0; i < 26; i++) {

      if (record[i] == 0) {
        continue;
      }

      record[i]--;
      sum++;
      sum+=help(record);
      record[i]++;

    }

    return sum;


  }
}
