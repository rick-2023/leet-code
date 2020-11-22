package tag.array.easy;

/**
 * @author zrfan
 * @date 2020/11/22.
 */
public class LeetCode_1450 {

  public int busyStudent(int[] startTime, int[] endTime, int queryTime) {

    int res=0;
    int length = startTime.length;

    for (int i = 0; i <= length-1; i++) {

      int start=startTime[i];
      int end =endTime[i];

      if (start<=queryTime && queryTime<=end){
        res++;
      }

    }

    return res;

  }
}
