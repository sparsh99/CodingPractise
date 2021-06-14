package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeEqualPartition {

  public static void main(String[] args) {
    System.out.println(new ThreeEqualPartition().solve(
        5,
        Arrays.asList(1, 2, 3, 0, 3)
    ));
  }

  public int solve(int A, List<Integer> B) {
    int totalSum = 0;
    for (int i=0; i<B.size(); i++) {
      totalSum += B.get(i);
    }

    if (totalSum % 3 != 0 || B.size() < 3) {
      return 0;
    }

    int expectedSum = totalSum / 3;
    int currSum = 0;
    int cnt1 = 0;
    int[] leftSumCnt = new int[A];
    for (int i=0; i<A-2; i++) {
      currSum += B.get(i);
      if (currSum == expectedSum) {
        cnt1++;
      }

      leftSumCnt[i] = cnt1;
    }

    System.out.println(Arrays.toString(leftSumCnt));

    int cnt2 = 0;
    currSum = 0;
    int ans = 0;
    for (int i=A-1; i>=2; i--) {
      currSum += B.get(i);
      if (currSum == expectedSum) {
        cnt2++;
        ans += cnt2 * leftSumCnt[i-2];
      }
    }

    return ans;
  }
}
