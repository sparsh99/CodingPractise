package dp;

public class RegularExpressionMatch2 {

  public static void main(String[] args) {
    System.out.println(new RegularExpressionMatch2().isMatch("aa", "a*a*a*"));
  }

  public boolean isMatch(String s, String p) {
    boolean[][] dp = new boolean[p.length() + 1][s.length() + 1];

    dp[0][0] = true; // for pattern of length 0 and empty string.
    // for (int i=1; i<=s.length() + 1; i++) {
    //     dp[0][i] = false; // for pattern of length 0 and non-empty string.
    // }

    int k=1;
    while (k <= p.length()) {
      if (k < p.length() && p.charAt(k) == '*') {
        dp[k+1][0] = true;
        k+=2;
      } else {
        break;
      }
    }

    for (int i=1; i<=p.length(); i++) {
      for (int j=1; j<=s.length(); j++) {
        char patternChar = p.charAt(i-1);
        Character patternPrevChar = (patternChar == '*') ? p.charAt(i-2) : null;
        char stringChar = s.charAt(j-1);

        if (patternChar == '*') {
          dp[i][j] = dp[i-2][j]
              || (dp[i][j-1] && (patternPrevChar == stringChar || patternPrevChar == '.'));
        } else if (patternChar == '.') {
          dp[i][j] = dp[i-1][j-1];
        } else {
          dp[i][j] = dp[i-1][j-1] && (patternChar == stringChar);
        }
      }
    }

    return dp[p.length()][s.length()];
  }
}
