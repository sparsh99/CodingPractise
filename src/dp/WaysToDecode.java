package dp;

public class WaysToDecode {

  public static void main(String[] args) {
    System.out.println(new WaysToDecode().numDecodings("10"));
    System.out.println(new WaysToDecode().numDecodings("012"));
    System.out.println(new WaysToDecode().numDecodings("10252"));
  }

  public int numDecodings(String A) {
    int MOD = 1000000007;
    long[] dp = new long[A.length()];
    if (A.length() == 0) return 0;

    if (A.length() >= 1) {
      int v = Integer.valueOf(A.substring(0, 1));
      dp[0] = (v>=1 && v<=9) ? 1 : 0;
    }

    if (A.length() >= 2) {
      int v = Integer.valueOf(A.substring(1, 2));
      int v1 = Integer.valueOf(A.substring(0, 2));
      dp[1] += dp[0] * ((v>=1 && v<=9) ? 1 : 0);
      dp[1] += ((v1>=10 && v1<=26) ? 1 : 0);
    }

    for (int i=2; i<A.length(); i++) {
      int v = Integer.valueOf(A.substring(i, i+1));
      int v1 = Integer.valueOf(A.substring(i-1, i+1));
      dp[i] = (dp[i-1] * ((v>=1 && v<=9) ? 1 : 0))%MOD;
      dp[i] = (dp[i] + (dp[i-2] * ((v1>=10 && v1<=26) ? 1 : 0))%MOD)%MOD;
    }

    return (int) dp[A.length()-1];
  }

}
