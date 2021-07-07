package tag.其他.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zrfan
 * @date 2021/07/07.
 */
public class ZigZagConversion_6 {

  public String convert(String s, int numRows) {

    int len = s.length();

    if (len <= numRows || numRows == 1) {
      return s;
    }

    List<StringBuilder> rows = new ArrayList<>();

    for (int i = 0; i < numRows; i++) {

      StringBuilder stringBuilder = new StringBuilder();
      rows.add(stringBuilder);

    }
    // 模拟这个 z型串的生成
    boolean down = false;
    int cur = 0;
    for (char c : s.toCharArray()) {

      if (cur == 0 || cur == numRows - 1) {
        down = !down;
      }

      rows.get(cur).append(c);

      cur = down ? cur + 1 : cur - 1;

    }

    StringBuilder res = new StringBuilder();
    for (StringBuilder row : rows) {
      res.append(row);
    }

    return res.toString();

  }

  public static void main(String[] args) {
    ZigZagConversion_6 zigZagConversion_6 = new ZigZagConversion_6();
    String paypalishiring = zigZagConversion_6.convert("PAYPALISHIRING", 3);
    System.out.println(paypalishiring);

  }
}
