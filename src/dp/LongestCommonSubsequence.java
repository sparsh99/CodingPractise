package dp;

public class LongestCommonSubsequence {

  public static void main(String[] args) {
    System.out.println(new LongestCommonSubsequence().solve("abbcdgf", "bbadcgf"));
  }

  public int solve(String A, String B) {
    int[][] dp = new int[A.length()][B.length()];
    for (int i=0; i<A.length(); i++) {
      for (int j=0; j<B.length(); j++) {
        if (i==0 && j==0) dp[i][j] = (A.charAt(i) == B.charAt(j)) ? 1 : 0;
        else if (i==0) dp[i][j] = Math.max(dp[i][j-1], ((A.charAt(i) == B.charAt(j)) ? 1 : 0));
        else if (j==0) dp[i][j] = Math.max(dp[i-1][j], ((A.charAt(i) == B.charAt(j)) ? 1 : 0));
        else {
          dp[i][j] = Math.max(
              Math.max(dp[i-1][j], dp[i][j-1]),
              dp[i-1][j-1] + ((A.charAt(i) == B.charAt(j)) ? 1 : 0)
          );
        }
      }
    }

    return dp[A.length()-1][B.length()-1];
  }
}
