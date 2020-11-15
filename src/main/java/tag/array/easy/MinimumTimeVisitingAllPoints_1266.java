package tag.array.easy;

/**
 * @author zrfan
 * @date 2020/11/15.
 */
public class MinimumTimeVisitingAllPoints_1266 {


  /**
   * 解题思路
   *  1.刚开始看这道题没想到要考察什么,后面看了其他人的答案才明白.
   *  2.每个坐标中x坐标和y坐标的距离最大值之和
   */
  public int minTimeToVisitAllPoints(int[][] points) {

    int res=0;
    for (int i = 1; i < points.length; i++) {

      int x = Math.abs(points[i][0]-points[i-1][0]);
      int y = Math.abs(points[i][1] -points[i-1][1]);

      res+=Math.max(x, y);


    }

    return res;
  }

  public static void main(String[] args) {

    int[][] points={{1,1},{3,4},{-1,0}};

    MinimumTimeVisitingAllPoints_1266 minimumTimeVisitingAllPoints_1266 = new MinimumTimeVisitingAllPoints_1266();
    int i = minimumTimeVisitingAllPoints_1266.minTimeToVisitAllPoints(points);
    System.out.println(i);


  }
}
