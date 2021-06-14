package math;

public class NoOfPaths {

  public static void main(String[] args) {
    System.out.println(new NoOfPaths().uniquePaths(2, 2));
  }

  public int uniquePaths(int A, int B) {
    int[][] dp = new int[A][B];
    for (int i=0; i<A; i++) {
      for (int j=0; j<B; j++) {
        if (i==0 && j==0) dp[i][j] = 1;
        else if (i==0) dp[i][j] = dp[i][j-1];
        else if (j==0) dp[i][j] = dp[i-1][j];
        else dp[i][j] = dp[i-1][j] + dp[i][j-1];
      }
    }

    return dp[A-1][B-1];
  }
}
