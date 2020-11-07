package tag.array.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zrfan
 * @date 2020/11/07.
 */
public class KidsWithTheGreatestNumberOfCandies_1431 {

  public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

    int max = -1;
    for (int i = 0; i < candies.length; i++) {

      max = candies[i] > max ? candies[i] : max;

    }


    List<Boolean> list = new ArrayList<>();
    for (int i = 0; i < candies.length; i++) {
//      int temp = candies[i]+extraCandies;
//      Boolean flag = false;
//      if (temp >= max) {
//        flag=true;
//      }
//      list.add(flag);
      list.add(candies[i] + extraCandies >= max);
    }

    return list;

  }


}
