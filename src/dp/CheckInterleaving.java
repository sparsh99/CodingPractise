package dp;

public class CheckInterleaving {

  public static void main(String[] args) {
//    System.out.println(new CheckInterleaving().isInterleave("B", "e", "Be"));
//    System.out.println(new CheckInterleaving().isInterleave(
//        "noUdRp97xFvpifeSXGwOjcVNhHo9N2D", "6iZItw9A3fj86uYx04tvWKLtl9BK",
//        "n6ioUdRpZ97ItwxF9Av3fj86upYxif0eS4XtvWKLtlG9wOBKjcVNhHo9N2D"
//    ));
    System.out.println(new CheckInterleaving().isInterleave(
        "sblIWKBF9yT3sAw4", "OxRZnGzMeMJ7ZCwidxBSTDyaNj1D",
        "OsxblRZnGIWKzBF9yTMyaNj1D"
    ));
  }

  public int isInterleave(String A, String B, String C) {
    if (A.length() + B.length() != C.length())
      return 0;

    boolean[][] dp = new boolean[A.length() + 1][B.length() + 1];
    for (int i = 0; i <= A.length(); i++) {
      for (int j = 0; j <= B.length(); j++) {
        if (i == 0 && j == 0) {
          dp[i][j] = true;
          continue;
        }
        dp[i][j] = (i > 0 && A.charAt(i - 1) == C.charAt(i + j - 1) && dp[i - 1][j])
            || (j > 0 && B.charAt(j - 1) == C.charAt(i + j - 1) && dp[i][j - 1]);
      }
    }
    return dp[A.length()][B.length()] ? 1 : 0;
  }

  public int isInterleaveBad(String A, String B, String C) {
    if (A.length() + B.length() > C.length()) return 0;

    // contains whether C[0..x+y] is interleaving of A[0..x] and B[0..y]
    boolean[][] dp = new boolean[A.length() + 1][B.length() + 1];

    dp[0][0] = true;

    for (int i=1; i<=A.length(); i++) {
      dp[i][0] = (A.substring(0, i).equals(C.substring(0, i)));
    }

    for (int i=1; i<=B.length(); i++) {
      dp[0][i] = (B.substring(0, i).equals(C.substring(0, i)));
    }

    for (int i=1; i<=A.length(); i++) {
      for (int j=1; j<=B.length(); j++) {
        for (int k=0; k<i; k++) {
          for (int l=0; l<j; l++) {
            String a = A.substring(k, i);
            String b = B.substring(l, j);
            String c = C.substring(k+l, i+j);
            dp[i][j] = dp[k][l] && (c.equals(a+b) || c.equals(b+a));
            if (dp[i][j]) break;
          }
          if (dp[i][j]) break;
        }
      }
    }

    return dp[A.length()][B.length()] ? 1 : 0;
  }
}
