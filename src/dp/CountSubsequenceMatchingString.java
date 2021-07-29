package dp;

public class CountSubsequenceMatchingString {

  /*
      https://www.interviewbit.com/old/problems/distinct-subsequences/
   */

  public static void main(String[] args) {
    System.out.println(
        new CountSubsequenceMatchingString().numDistinct("abc", "abc")
    );
    System.out.println(
        new CountSubsequenceMatchingString().numDistinct("rabbbit", "rabbit")
    );
    System.out.println(
        new CountSubsequenceMatchingString().numDistinct("aaaababbababbaabbaaababaaabbbaaabbb", "bbababa")
    );
  }

  public int numDistinct(String A, String B) {
    int dp[][] = new int[A.length()][B.length()];
    for (int j=0; j<B.length(); j++) {
      for (int i=j; i<A.length(); i++) {
        int a = A.charAt(i);
        int b = B.charAt(j);
        int offset = (a==b) ? 1 : 0;
        if (i==0 && j==0) dp[i][j] = offset;
        else if (i < j) dp[i][j] = 0;
        else if (j == 0) dp[i][j] = dp[i-1][j] + offset;
        else {
          dp[i][j] = dp[i-1][j] + (dp[i-1][j-1] * offset);
        }
      }
    }

    return dp[A.length()-1][B.length()-1];
  }
}
