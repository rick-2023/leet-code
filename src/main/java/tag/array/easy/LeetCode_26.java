package tag.array.easy;

/**
 * 移除数组中重复的元素
 * 技巧:快慢指针
 *
 * @author zrfan
 * @date 2022/09/26.
 */
public class LeetCode_26 {


  public int remove(int[] arr) {

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

  public static void main(String[] args) {

    LeetCode_26 leetCode_26 = new LeetCode_26();
    int res = leetCode_26.remove(new int[]{2, 2, 3, 3, 4, 5});
    System.out.println(res);
  }

}
