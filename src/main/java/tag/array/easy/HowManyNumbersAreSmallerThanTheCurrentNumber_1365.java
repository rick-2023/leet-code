package tag.array.easy;


/**
 * @author zrfan
 * @date 2020/11/08.
 */
public class HowManyNumbersAreSmallerThanTheCurrentNumber_1365 {

  public int[] smallerNumbersThanCurrent2(int[] nums) {

    return null;
  }

  /**
   * 暴力破解
   *
   *
   * @param nums
   * @return
   */
  public int[] smallerNumbersThanCurrent(int[] nums) {

    int[] res = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {

      int count = 0;
      for (int j = 0; j < nums.length; j++) {

        if (i!=j && nums[i] > nums[j]){

          count++;

        }

      }

      res[i] = count;


    }

    return res;
  }

}
