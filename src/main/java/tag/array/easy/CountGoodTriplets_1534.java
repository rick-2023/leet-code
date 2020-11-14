package tag.array.easy;

/**
 * @author zrfan
 * @date 2020/11/14.
 */
public class CountGoodTriplets_1534 {


  /**
   * 暴力破解
   *
   * 可以优化的点就是 a可以提前预判
   * 循环的次数按照 i，j,k 一次-1
   */
  public int countGoodTriplets(int[] arr, int a, int b, int c) {

    int length = arr.length;
    int res = 0;

    for (int i = 0; i < length-2; i++) {

      for (int j = i + 1; j < length-1; j++) {

        if (Math.abs(arr[i] - arr[j]) <= a) {

          for (int k = j + 1; k < length; k++){

            boolean valid = Math.abs(arr[j]-arr[k])<=b && Math.abs(arr[i]-arr[k])<=c;

            if (valid){
              res++;
            }
          }
        }


      }

    }

    return res;
  }

  public static void main(String[] args) {
    CountGoodTriplets_1534 countGoodTriplets_1534 = new CountGoodTriplets_1534();
    int[] arr={3, 0, 1, 1, 9, 7};
    int i = countGoodTriplets_1534.countGoodTriplets(arr, 7, 2, 3);

    System.out.println(i);



  }
}
