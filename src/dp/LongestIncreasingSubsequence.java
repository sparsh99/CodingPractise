package dp;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

  public static void main(String[] args) {
    System.out.println(new LongestIncreasingSubsequence().lis(
        new int[]{1, 2, 1, 5}
    ));
    System.out.println(new LongestIncreasingSubsequence().lis(
        new int[]{0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15}
    ));
  }

  public int lis(final int[] A) {
    int[] dp = new int[A.length];
    int maxLen = 0;
    for (int i=0; i<A.length; i++) {
      dp[i] = 1;
      for (int j=0; j<i; j++) {
        if (A[j] < A[i] && dp[i] < dp[j] + 1) {
          dp[i] = dp[j] + 1;
        }
      }

      if (dp[i] > maxLen) maxLen = dp[i];
    }

    return maxLen;
  }

}
