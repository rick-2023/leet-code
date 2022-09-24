package tag.stack.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 相关知识点 单调栈
 *
 * @author zrfan
 * @date 2022/09/24.
 */
public class LeetCode_496 {

  public int[] nextGreaterElement(int[] nums1, int[] nums2) {

    int[] nums2Result = help(nums2);
    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < nums2.length; i++) {

      map.put(nums2[i], nums2Result[i]);

    }


    int[] nums1Result = new int[nums1.length];
    for (int i = 0; i < nums1.length; i++) {
      nums1Result[i] = map.get(nums1[i]);
    }

    return nums1Result;

  }


  public static int[] help(int[] array) {

    if (array == null || array.length == 0) {
      return array;
    }

    int[] result = new int[array.length];
    int n = array.length;
    Stack<Integer> stack = new Stack<>();


    for (int i = n - 1; i >= 0; i--) {

      while (!stack.isEmpty() && array[i] >= stack.peek()) {
        stack.pop();
      }

      // 栈为空，表示右边没有比他大的元素了
      result[i] = stack.isEmpty() ? -1 : stack.peek();
      // 然后把该元素放入栈底
      stack.push(array[i]);

    }

    return result;
  }

  public static void main(String[] args) {
    LeetCode_496 leetCode_496 = new LeetCode_496();
    leetCode_496.nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2});
  }
}
