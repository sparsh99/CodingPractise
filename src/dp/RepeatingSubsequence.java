package dp;

public class RepeatingSubsequence {

  public static void main(String[] args) {
    System.out.println(
        new RepeatingSubsequence().anytwo("abab")
    );
    System.out.println(
        new RepeatingSubsequence().anytwo("abba")
    );
  }

  public int anytwo(String A) {
    // find lcs between A and A
    int dp[][] = new int[A.length()][A.length()];
    for (int i=0; i<A.length(); i++) {
      for (int j=0; j<A.length(); j++) {
        char a = A.charAt(i);
        char b = A.charAt(j);
        if (i==0 && j==0) dp[i][j] = 0;
        else if (i==0) dp[i][j] = Math.max(dp[i][j-1], ((a==b) ? 1 : 0));
        else if (j==0) dp[i][j] = Math.max(dp[i-1][j], ((a==b) ? 1 : 0));
        else {
          dp[i][j] = Math.max(
              Math.max(dp[i-1][j], dp[i][j-1]),
              dp[i-1][j-1] + ((i != j) && (a==b) ? 1 : 0)
          );
        }

        if (dp[i][j] >= 2) return 1;
      }
    }
    return 0;
  }

  /*
    Without DP
   */
  public int anytwoWithoutDP(String a) {
    for(int i=0;i<a.length();++i){
      for(int j=i+1;j<a.length();++j){
        char c = a.charAt(i), d = a.charAt(j);
        for(int k=0;k<a.length();++k){
          for(int m=k+1;m<a.length();++m){
            if(k!=i && m!=j && a.charAt(k)==c && a.charAt(m)==d) return 1;
          }
        }
      }
    }
    return 0;
  }
}
