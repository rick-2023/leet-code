package tag.array.medium;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 刚开始想错了，以为就找到第 k 位，没想到要排个序先。。
 * 优先队列第一次遇见，总结下
 *
 * 不清楚的话 debug 一下
 *
 * @author zrfan
 * @date 2021/07/22.
 */
public class kthSmallestElementSortedMatrix_378 {


  public static int kthSmallest(int[][] matrix, int k) {

    PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return o1[0] - o2[0];
      }
    });

    int row = matrix.length;
    int col = matrix[0].length;

    // 第一列 先全部放到优先队列中
    for (int i = 0; i < row; i++) {
      priorityQueue.offer(new int[]{matrix[i][0], i, 0});
    }


    // 接着按照 col 排序依次取出最小的放进去下一位
    // 循环结束 队列中最小的即第 k 大的
    for (int i = 0; i < k - 1; i++) {

      // 当前队列中的最小值
      int[] poll = priorityQueue.poll();
      if (poll[2] < col - 1) {

        int index = poll[2] + 1;
        priorityQueue.offer(new int[]{matrix[poll[1]][index], poll[1], index});

      }

    }

    // 最小的元素即答案
    return priorityQueue.poll()[0];

  }

  public static void main(String[] args) {
    int[][] matrix = {
            {1, 5, 9},
            {10, 11, 19},
            {12, 21, 25}
    };

    int i = kthSmallest(matrix, 8);
    System.out.println(i);
  }
}
