package dp;

public class RegularExpressionMatch {

  public static void main(String[] args) {
    System.out.println(new RegularExpressionMatch().isMatch("cc", "***??"));
    System.out.println(new RegularExpressionMatch().isMatch("", "*"));
  }

  /*
      Learn that we create dp matrix with extra size.
   */
  public boolean isMatch(String s, String p) {
    if (s == null || p == null) return true;

    int sLen = s.length(), pLen = p.length();

    boolean[][] dp = new boolean[sLen + 1][pLen + 1];
    dp[0][0] = true;

    for (int j = 1;j <= pLen;j++) {
      if (p.charAt(j - 1) != '*') break;
      dp[0][j] = true;
    }

    for (int i = 1;i <= sLen;i++) {
      for (int j = 1;j <= pLen;j++) {
        char c = p.charAt(j - 1);

        if (c == '?') {
          dp[i][j] = dp[i - 1][j - 1];
        } else if (c == '*') {
          dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
        } else {
          dp[i][j] = dp[i - 1][j - 1] && c == s.charAt(i - 1);
        }
      }
    }

    return dp[sLen][pLen];
  }

  public boolean isMatchLessOptimal(final String A, final String B) {
    if (B.length() == 0) return (A.length() == 0);
    if (A.length() == 0) {
      boolean onlyAsterisk = true;
      for (int j=0; j<B.length(); j++) {
        if (B.charAt(j) != '*')  onlyAsterisk = false;
      }

      return onlyAsterisk;
    }

    boolean [][] dp = new boolean[A.length()][B.length()];
    for (int i=0; i<A.length(); i++) {
      boolean onlyAsterisk = true;
      for (int j=0; j<B.length(); j++) {
        if (i==0 && j==0) {
          dp[i][j] =
              (B.charAt(j) == '?'
                  || B.charAt(j) == '*'
                  || B.charAt(j) == A.charAt(i));
        } else if (i==0) {
          dp[i][j] = dp[i][j-1] && B.charAt(j) == '*'
              || (onlyAsterisk && (A.charAt(i) == B.charAt(j) || B.charAt(j) == '?'));
        } else if (j==0) {
          dp[i][j] = (B.charAt(j) == '*');
        } else {
          dp[i][j] = (dp[i-1][j-1]
              && (A.charAt(i)==B.charAt(j)
              || B.charAt(j)=='?' || B.charAt(j)=='*'))
              || (dp[i][j-1] && B.charAt(j)=='*')
              || (dp[i-1][j] && B.charAt(j)=='*');
        }

        if (B.charAt(j) != '*') onlyAsterisk = false;
      }
    }

    return dp[A.length()-1][B.length()-1];
  }
}
