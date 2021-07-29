package dp;

public class NDigitNoWithSum {

  public static void main(String[] args) {
    System.out.println(new NDigitNoWithSum().solve(2, 2));
    System.out.println(new NDigitNoWithSum().solve(2, 4));
  }

  public int solve(int A, int B) {
    int MOD = 1000000007;
    long[][] dp = new long[A+1][B+1];
    // dp[N][S] = Sum { dp[N-1][S] + dp[N-1][S-1] + .. + dp[N-1][S-9] }
    for (int s=0; s<=B; s++)
      dp[0][s] = 1;
    for (int n=1; n<=A; n++) {
      for (int s=0; s<=B; s++) {
        int start = (n == A && A > 1) ? 1 : 0;
        for (int d=start; d<=9; d++) {
          if (n==1) {
            dp[n][s] = dp[n][s] + ((s == d) ? 1 : 0);
          } else if (s >= d) {
            dp[n][s] = (dp[n][s] + dp[n-1][s-d])%MOD;
          }
        }
      }
    }

    return (int) dp[A][B];
  }
}
