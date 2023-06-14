package tag.array.medium;

import java.util.Arrays;

/**
 * 题目刚开始比较难理解.... 先搁着没get
 * Input: citations = [3,0,6,1,5]
 * Output: 3
 * Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively.
 * Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, their h-index is 3.
 * <p>
 * 有n篇文章，每篇被引用的次数是它的index对应的值
 *
 * @author zrfan
 * @date 2023/06/14.
 */
public class HIndex_274 {

  public int hIndex(int[] citations) {

    Arrays.sort(citations);

    int h = citations.length;
    for (int citation : citations) {

      if (citation >= h) {
        return h;
      }

      h--;

    }
    return 0;
  }
}
