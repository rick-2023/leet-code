package tag.stack.medium;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author zrfan
 * @date 2020/02/03.
 */
public class LeetCode_739 {

  /**
   * 分析
   *  复制一个新的数组res,由于结果是天数与实际温度差无关 故想到 栈 存储的数组下标
   *  递减栈。每次遍历数组 入栈。
   *  判断栈非空&&栈顶元素是否小于当前元素即温度有上升 出栈并维护res为当前元素i与栈顶t的下标之差即为天数。
   *
   *  本题想不出 参考网上 特此记录方便后面继续回顾复习
   *
   * @param T
   * @return
   */

  public int[] dailyTemperatures(int[] T) {

    Stack<Integer> stack = new Stack();
    int length = T.length;
    int[] res = new int[length];
    Arrays.fill(res, 0);

    for(int i=0;i<length;i++){

      while(!stack.isEmpty() && T[stack.peek()] < T[i]){
        int t = stack.pop();

        res[t] = i-t;
      }

      stack.push(i);

    }

    return res;


  }
}
