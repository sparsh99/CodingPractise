package arrays;

import java.util.Arrays;
import java.util.List;

public class MaxSumContigSubArr {

  public static void main(String[] args) {
    System.out.println(new MaxSumContigSubArr().maxSubArray(
        Arrays.asList(-2, 1, -3, 4, -1, 2, 1, -5, 4)
    ));
  }

  public int maxSubArray(final List<Integer> A) {
    int sum = 0;
    int maxSum = Integer.MIN_VALUE;
    for (int i=0; i<A.size(); i++) {
      sum += A.get(i);
      if (sum > maxSum) {
        maxSum = sum;
      }

      if (sum < 0) {
        sum = 0;
      }
    }

    return maxSum;
  }
}
