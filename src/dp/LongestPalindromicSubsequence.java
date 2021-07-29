package dp;

public class LongestPalindromicSubsequence {

  public static void main(String[] args) {
    System.out.println(new LongestPalindromicSubsequence().solve("bebeeed"));
    System.out.println(new LongestPalindromicSubsequence().solve("bebdeeedaddecebbbbbabebedc"));
  }

  public int solve(String A) {
    int[][] dp = new int[A.length()][A.length()];
    int maxLength = 0;
    for (int len=0; len<A.length(); len++) { // length
      for (int i=0; i<A.length() - len; i++) { // starting index
        if (len == 0) {
          dp[i][i+len] = 1;
        } else if (len == 1) {
          dp[i][i+len] = (A.charAt(i) == A.charAt(i+len)) ? 2 : 1;
        } else {
          dp[i][i+len] = Math.max(
              Math.max(dp[i+1][i+len], dp[i][i+len-1]),
              dp[i+1][i+len-1] + ((A.charAt(i) == A.charAt(i+len)) ? 2 : 0)
          );
        }

        if (dp[i][i+len] > maxLength) maxLength = dp[i][i+len];
      }
    }

    return maxLength;
  }

}
