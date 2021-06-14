package bitmanipulation;

import java.util.Arrays;
import java.util.List;

public class FindSingleNumberThreeRepeat {

  public static void main(String[] args) {
    System.out.println(new FindSingleNumberThreeRepeat().singleNumber(
        Arrays.asList(1, 2, 4, 3, 3, 2, 2, 3, 1, 1)
    ));
  }

  public int singleNumber(final List<Integer> A) {
    int ans = 0;
    for (int i=32; i>=0; i--) {
      int cnt1 = 0;
      int cleanKey = 1 << i;
      for (int j=0; j<A.size(); j++) {
        if ((cleanKey & A.get(j)) > 0) {
          cnt1++;
        }
      }

      ans = ans*2 + cnt1%3;
    }

    return ans;
  }
}
