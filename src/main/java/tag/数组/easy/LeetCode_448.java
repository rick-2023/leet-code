package tag.数组.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zrfan
 * @date 2020/01/30.
 */
public class LeetCode_448 {


  /**
   * 思路
   *  正负数标记法
   *  遍历数组 "num-1" 作为新的下标找到对应元素 若为正数则置为负数
   *  第二次遍历 找到下标i为正数的 (i+1) add 到list 中
   * @param nums
   * @return
   */
  public List<Integer> findDisappearedNumbers(int[] nums) {


    for(int i=0;i<nums.length;i++){

      int index = Math.abs(nums[i])-1;

      if(nums[index]>0) {
        nums[index] = -nums[index];
      }

    }

    List<Integer> list = new ArrayList<>();
    for(int i=0;i<nums.length;i++){
      if(nums[i]>0){
        list.add(i+1);
      }
    }

    return list;

  }
}
