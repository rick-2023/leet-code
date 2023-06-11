package tag.array.easy;

import org.junit.Test;

import java.util.Arrays;

/**
 * 从nums1尾巴开始扫描，依次比较n1, n2的值，那个大就依次放入nums1的尾巴，i--
 *
 * @author zrfan
 * @date 2023/06/11.
 */
public class MergeSortedArray_88 {

  public void merge(int[] nums1, int m, int[] nums2, int n) {

    int len = nums1.length;

    for (int i = len - 1; i >= 0; i--) {

      m = m - 1;
      n = n - 1;

      if (m < 0) {
        nums1[i] = nums2[n];
        n--;
        continue;
      }

      if (n < 0) {
        nums1[i] = nums1[m];
        m--;
        continue;
      }

      if (nums2[n] >= nums1[m]) {

        nums1[i] = nums2[n];
        n--;

      } else {

        nums1[i] = nums1[m];
        m--;

      }

    }

  }


  @Test
  public void test() {

    MergeSortedArray_88 mergeSortedArray88 = new MergeSortedArray_88();
    int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
    mergeSortedArray88.merge(nums1, 3, new int[]{2, 5, 6}, 3);

    Arrays.stream(nums1).forEach(i -> System.out.println(i));

  }
}
