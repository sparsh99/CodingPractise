package dp;

public class MinDistance {

  public static void main(String[] args) {
    System.out.println(new MinDistance().minDistance("aaa", "abad"));
    System.out.println(new MinDistance().minDistance("aaa", "aba"));
    System.out.println(new MinDistance().minDistance("aaa", "aa"));
    System.out.println(new MinDistance().minDistance("xyz", "aa"));
    System.out.println(new MinDistance().minDistance("Anshuman", "Antihuman"));
  }

  public int minDistance(String A, String B) {
    int[][] dp = new int[A.length()][B.length()]; // minimum way to convert (0, i) to (0, j)
    for (int i=0; i<A.length(); i++) {
      for (int j=0; j<B.length(); j++) {
        int offset = (A.charAt(i) == B.charAt(j)) ? 0 : 1;
        if (i==0 && j==0) {
          dp[i][j] = offset;
        } else if (i==0) {
          dp[i][j] = Math.min(dp[i][j-1] + 1, j+offset);
        } else if (j==0) {
          dp[i][j] = Math.min(dp[i-1][j] + 1, i+offset);
        } else {
          dp[i][j] = Math.min(
              dp[i-1][j] + 1, Math.min(dp[i][j-1] + 1, dp[i-1][j-1] + offset)
          );
        }
      }
    }

    return dp[A.length()-1][B.length()-1];
  }

  /*
    This is how not to write DP. First think of simple recursion on paper and then
    move to DP.
   */
  public int minDistanceN4(String A, String B) {
    int[][][][] dp = new int[A.length()][A.length()][B.length()][B.length()];
    for (int lenB = 0; lenB<B.length(); lenB++) {
      for (int lenA = 0; lenA < A.length(); lenA++) {
        for (int ib = 0; ib<B.length() - lenB; ib++) {
          int x = ib;
          int y = ib + lenB;

          for (int ia=0; ia<A.length()-lenA; ia++) {
            int a = ia;
            int b = ia + lenA;

            if (lenB == 0 && lenA == 0) {
              dp[a][b][x][y] = (A.charAt(a) == B.charAt(x)) ? 0 : 1;
            } else if (lenA == 0) {
              dp[a][b][x][y] = Math.min(
                  dp[a][b][x][y-1] + 1, // Insert
                  dp[a][b][x+1][y] + 1 // Insert
              );
            } else if (lenB == 0) {
              dp[a][b][x][y] = Math.min(
                  dp[a+1][b][x][y] + 1, // Insert
                  dp[a][b-1][x][y] + 1 // Insert
              );
            } else {
              dp[a][b][x][y] = Math.min(
                  Math.min(
                      dp[a][b][x][y-1] + 1, // Insert
                      dp[a][b][x+1][y] + 1 // Insert
                  ),
                  Math.min(
                      Math.min(
                          dp[a+1][b][x][y] + 1, // Delete
                          dp[a][b-1][x][y] + 1  // Delete
                      ),
                      Math.min(
                          dp[a+1][b][x+1][y]
                              + ((A.charAt(a) == B.charAt(x)) ? 0 : 1), // Replace
                          dp[a][b-1][x][y-1]
                              + ((A.charAt(b) == B.charAt(y)) ? 0 : 1) // Replace
                      )
                  )
              );
            }
          }
        }
      }
    }

    return dp[0][A.length()-1][0][B.length()-1];
  }
}
