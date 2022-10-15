package tag.array.easy;

import org.junit.Test;

/**
 * 移除数组中重复的元素，返回新数组的长度
 *
 * 技巧:快慢指针
 *
 * @author zrfan
 * @date 2022/09/26.
 */
public class LeetCode_26 {


  public static int remove(int[] arr) {

    if (arr == null || arr.length == 0) {
      return 0;
    }

    int slow = 0, fast = 0;

    while (fast < arr.length) {

      if (arr[slow] != arr[fast]) {
        slow++;
        arr[slow] = arr[fast];
      }

      fast++;

    }

    // slow索引加1
    return slow + 1;

  }

  @Test
  public void test() {

    int res = remove(new int[]{2, 2, 3, 3, 4, 5});
    System.out.println(res);
  }

}
