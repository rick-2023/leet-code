package tag.其他.medium;

/**
 * @author zrfan
 * @date 2023/05/16.
 */
public class CompareVersionNumbers_165 {


  /**
   * Input: version1 = "0.1", version2 = "1.1"
   * Output: -1
   * Explanation: version1's revision 0 is "0", while version2's revision 0 is "1". 0 < 1, so version1 < version2.
   *
   * @param version1 版本1
   * @param version2 版本2
   * @return 哪个版本大
   */
  public int compareVersion(String version1, String version2) {

    String[] v1 = version1.split("\\.");
    String[] v2 = version2.split("\\.");

    int max = Math.max(v1.length, v2.length);

    for (int i = 0; i < max; i++) {

      int num1 = i < v1.length ? Integer.parseInt(v1[i]) : 0;
      int num2 = i < v2.length ? Integer.parseInt(v2[i]) : 0;

      if (num1 > num2) {
        return 1;
      }

      if (num2 > num1) {
        return -1;
      }

    }

    return 0;

  }


}
