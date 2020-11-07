package tag.array.medium;

import java.util.PriorityQueue;

/**
 * @author zrfan
 * @date 2020/02/07.
 */
public class LeetCode_215 {

  /**
   * 使用队列
   *
   * @param nums
   * @param k
   * @return
   */
  public int findKthLargest(int[] nums, int k) {

    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

    for (int i = 0; i < nums.length; i++) {

      priorityQueue.offer(nums[i]);

      if (priorityQueue.size() > k) {
        priorityQueue.poll();
      }
    }

    return priorityQueue.peek();
  }

  // 方法二 数组排序 取[length-k]

  public static void main(String[] args) {

    int[] nums = {2,1,3,4,8,6};
    int k =2;
    // 测试
    LeetCode_215 leetCode_215 = new LeetCode_215();
    int num = leetCode_215.findKthLargest(nums, k);
    System.out.println(num);
  }
}
